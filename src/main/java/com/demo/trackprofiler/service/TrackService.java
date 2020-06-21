package com.demo.trackprofiler.service;

import com.demo.trackprofiler.domain.viewmodel.TrackListVM;
import com.demo.trackprofiler.domain.viewmodel.TrackVM;

public interface TrackService {
    TrackListVM findAllTracks();
    TrackVM findTrackById(Integer trackId);
}
