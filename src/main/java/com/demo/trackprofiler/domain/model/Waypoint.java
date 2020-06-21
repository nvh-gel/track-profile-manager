package com.demo.trackprofiler.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Waypoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int waypointId;

    private BigDecimal latitude;
    private BigDecimal longitude;
    private String name;
    private String symbol;

    public int getWaypointId() {
        return waypointId;
    }

    public void setWaypointId(int waypointId) {
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
}
