package com.demo.trackprofiler.domain.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class TrackPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trackPointId;

    @ManyToOne
    @JoinColumn(name = "track_id", nullable = false)
    private Track track;

    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal elevation;
    private LocalDateTime time;

    public Integer getTrackPointId() {
        return trackPointId;
    }

    public void setTrackPointId(Integer trackPointId) {
        this.trackPointId = trackPointId;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getElevation() {
        return elevation;
    }

    public void setElevation(BigDecimal elevation) {
        this.elevation = elevation;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
