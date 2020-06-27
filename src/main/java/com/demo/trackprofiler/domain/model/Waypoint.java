package com.demo.trackprofiler.domain.model;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "waypoint")
public class Waypoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer waypointId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_id", nullable = false)
    private Track track;

    private BigDecimal latitude;
    private BigDecimal longitude;
    private String name;
    private String symbol;

    public Integer getWaypointId() {
        return waypointId;
    }

    public void setWaypointId(Integer waypointId) {
        this.waypointId = waypointId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}

