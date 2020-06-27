package com.demo.trackprofiler.domain.viewmodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class TrackSegmentsVM {

    private List<TrackPointVM> trackPointVMs;

    @XmlElementWrapper(name = "trkseg")
    @XmlElement(name = "trkpt")
    public List<TrackPointVM> getTrackPointVMs() {
        return trackPointVMs;
    }

    public void setTrackPointVMs(List<TrackPointVM> trackPointVMs) {
        this.trackPointVMs = trackPointVMs;
    }
}
