package com.demo.trackprofiler.domain.viewmodel;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.Date;

/**
 * View models that contain track point data that is received from user or will be showed to user
 * Utilizing annotation to map with the uploaded gpx file
 */
public class TrackPointVM {

    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal elevation;
    private Date time;

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

    @XmlElement(name = "ele")
    public BigDecimal getElevation() {
        return elevation;
    }

    public void setElevation(BigDecimal elevation) {
        this.elevation = elevation;
    }

    @XmlElement
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
