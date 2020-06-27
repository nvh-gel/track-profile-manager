package com.demo.trackprofiler.domain.viewmodel;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

/**
 * View models that contain waypoints data that is received from user or will be showed to user
 * Utilizing annotation to map with the uploaded gpx file
 */
public class WaypointVM {

    private BigDecimal latitude;
    private BigDecimal longitude;
    private String name;
    private String symbol;

    /*----------------------------------*
     Getters and Setters
     *----------------------------------*/

    @XmlAttribute(name = "lat")
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @XmlAttribute(name = "lon")
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "sym")
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
