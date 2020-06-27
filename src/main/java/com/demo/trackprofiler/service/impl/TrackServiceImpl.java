package com.demo.trackprofiler.service.impl;

import com.demo.trackprofiler.domain.model.Track;
import com.demo.trackprofiler.domain.repository.TrackRepository;
import com.demo.trackprofiler.domain.viewmodel.TrackListVM;
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
import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    private static final String UPLOADED_DIR = "D://temp//";

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Override
    public TrackListVM findAllTracks() {
        TrackListVM trackListVM = new TrackListVM();
        List<Track> trackList = trackRepository.findAll();

        dozerBeanMapper.map(trackList, trackListVM);
        return trackListVM;
    }

    @Override
    public TrackVM findTrackById(Integer trackId) {
        TrackVM trackVM = new TrackVM();
        Track trackModel = trackRepository.findOne(trackId);
        dozerBeanMapper.map(trackModel, trackVM);
        TrackMetadataVM metadata = new TrackMetadataVM();
        dozerBeanMapper.map(trackModel, metadata);
        Link link = new Link();
        dozerBeanMapper.map(trackModel, link);
        metadata.setLink(link);
        trackVM.setMetadata(metadata);
        TrackSegmentsVM trackSegments =  new TrackSegmentsVM();
        dozerBeanMapper.map(trackModel, trackSegments);
        trackVM.setTrackSegments(trackSegments);
        return trackVM;
    }

    @Override
    public void processUploadedFile(MultipartFile file) throws IOException, JAXBException {
//        byte[] bytes = file.getBytes();
//        Path path = Paths.get(UPLOADED_DIR, file.getOriginalFilename());
//        Files.write(path, bytes);

        // TODO move this to a new thread or using queue system to speed up processing
        File uploadedFile = new File("D:\\temp\\sample.gpx");
        JAXBContext jaxbContextObj = JAXBContext.newInstance(TrackVM.class);
        Unmarshaller unmarshaller = jaxbContextObj.createUnmarshaller();
        TrackVM trackVM = (TrackVM) unmarshaller.unmarshal(uploadedFile);

        Track trackModel = new Track();
        dozerBeanMapper.map(trackVM, trackModel);
        dozerBeanMapper.map(trackVM.getMetadata(), trackModel);
        dozerBeanMapper.map(trackVM.getMetadata().getLink(), trackModel);
        dozerBeanMapper.map(trackVM.getTrackSegments(), trackModel);

        trackRepository.saveAndFlush(trackModel);
    }

    public TrackRepository getTrackRepository() {
        return trackRepository;
    }

    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public DozerBeanMapper getDozerBeanMapper() {
        return dozerBeanMapper;
    }

    public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper) {
        this.dozerBeanMapper = dozerBeanMapper;
    }
}
