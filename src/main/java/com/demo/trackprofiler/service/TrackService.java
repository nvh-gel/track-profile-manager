package com.demo.trackprofiler.service;

import com.demo.trackprofiler.domain.model.Track;
import com.demo.trackprofiler.domain.viewmodel.TrackListVM;
import com.demo.trackprofiler.domain.viewmodel.TrackVM;

import java.util.List;

public interface TrackService {
    TrackListVM findAllTracks();
    List<Track> findAllTrackModels();
    TrackVM findTrackById(Integer trackId);
}
