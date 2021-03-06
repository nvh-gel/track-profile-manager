package com.demo.trackprofiler.domain.viewmodel;

import com.demo.trackprofiler.utils.Link;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * View models that contain track metadata that is received from user or will be showed to user
 * Utilizing annotation to map with the uploaded gpx file
 */
@XmlRootElement
public class TrackMetadataVM {

    private String name;
    private String desc;
    private String author;
    private Link link;
    private Date time;

    /*----------------------------------*
     Constructors
     *----------------------------------*/

    public TrackMetadataVM() {
    }

    public TrackMetadataVM(String name, String desc, String author, Link link, Date time) {
        this.name = name;
        this.desc = desc;
        this.author = author;
        this.link = link;
        this.time = time;
    }

    /*----------------------------------*
     Validation methods
     *----------------------------------*/

    public boolean isEqual(TrackMetadataVM target) {
        return this.name.equals(target.name)
                && this.desc.equals(target.desc)
                && this.author.equals(target.author)
                && this.link.isEqual(target.link)
                && this.time.equals(target.time);
    }

    /*----------------------------------*
     Getters and Setters
     *----------------------------------*/

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @XmlElement
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlElement
    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @XmlElement
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
