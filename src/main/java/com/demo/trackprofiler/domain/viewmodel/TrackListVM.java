package com.demo.trackprofiler.domain.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class TrackListVM {
    List<TrackVM> tracks;

    public TrackListVM() {
        this.tracks = new ArrayList<>();
    }

    public TrackListVM(List<TrackVM> trackVMS) {
        this.tracks = trackVMS;
    }

    public List<TrackVM> getTracks() {
        return tracks;
    }

    public void setTracks(List<TrackVM> tracks) {
        this.tracks = tracks;
    }
}
