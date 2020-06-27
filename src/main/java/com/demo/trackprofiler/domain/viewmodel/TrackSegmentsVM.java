package com.demo.trackprofiler.domain.viewmodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * View models that contain wrapper for track points that is received from user or will be showed to user
 * Utilizing annotation to map with the uploaded gpx file
 */
public class TrackSegmentsVM {

    private List<TrackPointVM> trackPoints;

    /*----------------------------------*
     Getters and Setters
     *----------------------------------*/

    @XmlElementWrapper(name = "trkseg")
    @XmlElement(name = "trkpt")
    public List<TrackPointVM> getTrackPoints() {
        return trackPoints;
    }

    public void setTrackPoints(List<TrackPointVM> trackPoints) {
        this.trackPoints = trackPoints;
    }
}
