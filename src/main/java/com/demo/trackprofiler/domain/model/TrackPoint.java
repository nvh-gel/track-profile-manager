package com.demo.trackprofiler.domain.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Model to hold track point data contained inside track
 */
@Entity
public class TrackPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trackPointId;

    private Integer trackId;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal elevation;
    private LocalDateTime time;

    /*----------------------------------*
     Getters and Setters
     *----------------------------------*/

    public Integer getTrackPointId() {
        return trackPointId;
    }

    public void setTrackPointId(Integer trackPointId) {
        this.trackPointId = trackPointId;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
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
