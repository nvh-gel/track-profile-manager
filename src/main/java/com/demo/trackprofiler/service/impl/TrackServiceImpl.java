package com.demo.trackprofiler.service.impl;

import com.demo.trackprofiler.domain.model.Track;
import com.demo.trackprofiler.domain.model.TrackPoint;
import com.demo.trackprofiler.domain.model.Waypoint;
import com.demo.trackprofiler.domain.repository.TrackPointRepository;
import com.demo.trackprofiler.domain.repository.TrackRepository;
import com.demo.trackprofiler.domain.repository.WaypointRepository;
import com.demo.trackprofiler.domain.viewmodel.TrackMetadataVM;
import com.demo.trackprofiler.domain.viewmodel.TrackSegmentsVM;
import com.demo.trackprofiler.domain.viewmodel.TrackVM;
import com.demo.trackprofiler.service.TrackService;
import com.demo.trackprofiler.utils.Link;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Implementation class for TrackService
 */
@Service
public class TrackServiceImpl implements TrackService {

    private static final String UPLOADED_DIR = "D://temp//";

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private WaypointRepository waypointRepository;

    @Autowired
    private TrackPointRepository trackPointRepository;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TrackVM> findAllTracks() {

        // retrieve all latest tracks
        List<Track> tracks = trackRepository.findAllByOrderByTimeDesc();

        // map metadata and link to track list and return VM list
        return tracks.stream().map(track -> {
            TrackVM trackVM = new TrackVM();
            TrackMetadataVM metadata = new TrackMetadataVM();
            Link link = new Link();

            dozerBeanMapper.map(track, trackVM);
            dozerBeanMapper.map(track, metadata);
            dozerBeanMapper.map(track, link);

            metadata.setLink(link);
            trackVM.setMetadata(metadata);

            return trackVM;
        }).collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TrackVM findTrackById(Integer trackId) {

        Track trackModel = trackRepository.findOne(trackId);

        // if found processing mapping to VM, else return nulll
        if (trackModel != null) {
            TrackVM trackVM = new TrackVM();

            trackModel.setWaypoints(waypointRepository.findWaypointsByTrackId(trackId));
            trackModel.setTrackPoints(trackPointRepository.findTrackPointsByTrackId(trackId));

            dozerBeanMapper.map(trackModel, trackVM);  // map id and waypoints

            // map metadata to VM
            TrackMetadataVM metadata = new TrackMetadataVM();
            dozerBeanMapper.map(trackModel, metadata);
            Link link = new Link();
            dozerBeanMapper.map(trackModel, link);
            metadata.setLink(link);
            trackVM.setMetadata(metadata);

            TrackSegmentsVM trackSegments = new TrackSegmentsVM();
            dozerBeanMapper.map(trackModel, trackSegments);
            trackVM.setTrackSegments(trackSegments);

            return trackVM;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processUploadedFile(MultipartFile file) throws IOException, JAXBException {
        // save the uploaded file to temp directory
        byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOADED_DIR, file.getOriginalFilename());
        File directory = new File(UPLOADED_DIR);
        if (!directory.exists()) {
            boolean dirCreated = directory.mkdir();
            if (!dirCreated) {
                throw new IOException("Cannot create directory for uploaded file");
            }
        }
        Files.write(path, bytes);

        // TODO move this to a new thread or using queue system to speed up processing
        // processing uploaded file, using JAXB to map uploaded file to TrackVM object
        File uploadedFile = path.toFile();
        JAXBContext jaxbContextObj = JAXBContext.newInstance(TrackVM.class);
        Unmarshaller unmarshaller = jaxbContextObj.createUnmarshaller();
        TrackVM trackVM = (TrackVM) unmarshaller.unmarshal(uploadedFile);

        // map metadata from TrackVM to model Track to save to database
        Track trackModel = new Track();
        dozerBeanMapper.map(trackVM, trackModel);
        dozerBeanMapper.map(trackVM.getMetadata(), trackModel);
        dozerBeanMapper.map(trackVM.getMetadata().getLink(), trackModel);

        // persist track to database
        Track result = trackRepository.save(trackModel);

        if (result != null) {
        /* Because Dozer mapping for collection is limited and may causes issues,
           we have to iterate and map one by one for waypoints and track points */
            List<Waypoint> waypoints = trackVM.getWaypoints().stream().map(wp -> {
                Waypoint waypoint = new Waypoint();
                dozerBeanMapper.map(wp, waypoint);
                waypoint.setTrackId(result.getTrackId());
                return waypoint;
            }).collect(Collectors.toList());

            List<TrackPoint> trackPoints = trackVM.getTrackSegments().getTrackPoints().stream().map(tp -> {
                TrackPoint trackPoint = new TrackPoint();
                dozerBeanMapper.map(tp, trackPoint);
                trackPoint.setTrackId(result.getTrackId());
                return trackPoint;
            }).collect(Collectors.toList());

            // persist waypoints and track points to database
            waypointRepository.save(waypoints);
            trackPointRepository.save(trackPoints);
        }
    }
}
