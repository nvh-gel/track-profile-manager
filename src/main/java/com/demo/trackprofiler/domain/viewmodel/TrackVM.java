package com.demo.trackprofiler.domain.viewmodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "gpx")
public class TrackVM {

    private int trackId;

    private TrackMetadataVM metadata;

    // waypoints
    private List<WaypointVM> waypoints;

    // track points
    private TrackSegmentsVM trackSequenceVM;

    // Constructors

    public TrackVM() {}


    // Getter and Setter

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
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
    public TrackSegmentsVM getTrackSequenceVM() {
        return trackSequenceVM;
    }

    public void setTrackSequenceVM(TrackSegmentsVM trackSequenceVM) {
        this.trackSequenceVM = trackSequenceVM;
    }
}
