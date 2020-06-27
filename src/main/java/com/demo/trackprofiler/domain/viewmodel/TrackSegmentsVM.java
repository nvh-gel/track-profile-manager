package com.demo.trackprofiler.domain.viewmodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class TrackSegmentsVM {

    private List<TrackPointVM> trackPoints;

    @XmlElementWrapper(name = "trkseg")
    @XmlElement(name = "trkpt")
    public List<TrackPointVM> getTrackPoints() {
        return trackPoints;
    }

    public void setTrackPoints(List<TrackPointVM> trackPoints) {
        this.trackPoints = trackPoints;
    }
}
