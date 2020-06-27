package com.demo.trackprofiler.domain.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Model to hold the data for track.
 */
@Entity
@Table(name = "track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trackId;

    // metadata
    private String name;
    private String description;
    private String author;
    private String url;
    private String urlText;
    private LocalDateTime time;

    @Transient
    private List<Waypoint> waypoints;

    @Transient
    private List<TrackPoint> trackPoints;

    /*----------------------------------*
     Constructors
     *----------------------------------*/
    public Track() {}

    public Track(Integer trackId, String name, String description, String author, String url, String urlText, LocalDateTime time) {
        this.trackId = trackId;
        this.name = name;
        this.description = description;
        this.author = author;
        this.url = url;
        this.urlText = urlText;
        this.time = time;
    }

    /*----------------------------------*
     Getters and Setters
     *----------------------------------*/

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlText() {
        return urlText;
    }

    public void setUrlText(String urlText) {
        this.urlText = urlText;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void setTrackPoints(List<TrackPoint> trackPoints) {
        this.trackPoints = trackPoints;
    }
}
