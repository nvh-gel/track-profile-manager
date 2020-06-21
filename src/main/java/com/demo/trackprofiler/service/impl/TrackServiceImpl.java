package com.demo.trackprofiler.service.impl;

import com.demo.trackprofiler.domain.model.Track;
import com.demo.trackprofiler.domain.model.TrackPoint;
import com.demo.trackprofiler.domain.repository.TrackPointRepository;
import com.demo.trackprofiler.domain.repository.TrackRepository;
import com.demo.trackprofiler.domain.viewmodel.TrackListVM;
import com.demo.trackprofiler.domain.viewmodel.TrackVM;
import com.demo.trackprofiler.service.TrackService;
import com.demo.trackprofiler.utils.Link;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private TrackPointRepository trackPointRepository;

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
        Track track = trackRepository.findOne(trackId);
        dozerBeanMapper.map(track, trackVM);
        trackVM.setLink(dozerBeanMapper.map(track, Link.class));
        List<TrackPoint> trackPoints = trackPointRepository.findAllByTrackId(trackId);
        dozerBeanMapper.map(trackPoints.toArray(), trackVM);
        return trackVM;
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
