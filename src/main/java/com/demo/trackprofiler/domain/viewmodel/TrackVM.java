package com.demo.trackprofiler.domain.viewmodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * View models that contain track data that is received from user or will be showed to user
 * Utilizing annotation to map with the uploaded gpx file
 */
@XmlRootElement(name = "gpx")
public class TrackVM {

    private Integer trackId;

    // metadata
    private TrackMetadataVM metadata;
    // waypoints
    private List<WaypointVM> waypoints;
    // track points
    private TrackSegmentsVM trackSegments;

    /*----------------------------------*
     Getters and Setters
     *----------------------------------*/

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    @XmlElement
    public TrackMetadataVM getMetadata() {
        return metadata;
    }

    public void setMetadata(TrackMetadataVM metadata) {
        this.metadata = metadata;
    }

    @XmlElement(name = "wpt")
    public List<WaypointVM> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<WaypointVM> waypoints) {
        this.waypoints = waypoints;
    }

    @XmlElement(name = "trk")
    public TrackSegmentsVM getTrackSegments() {
        return trackSegments;
    }

    public void setTrackSegments(TrackSegmentsVM trackSegments) {
        this.trackSegments = trackSegments;
    }
}
