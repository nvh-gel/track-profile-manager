package com.demo.trackprofiler.domain.model;

import com.demo.trackprofiler.utils.Coordinate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TrackPoint {
    private int trackPointId;

    private Coordinate coordinate;
    private BigDecimal elevation;
    private LocalDateTime time;

    public int getTrackPointId() {
        return trackPointId;
    }

    public void setTrackPointId(int trackPointId) {
        this.trackPointId = trackPointId;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
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
