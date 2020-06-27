package com.demo.trackprofiler.domain.viewmodel;

import com.demo.trackprofiler.utils.Link;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;

@XmlRootElement
public class TrackMetadataVM {

    private String name;
    private String desc;
    private String author;
    private Link link;
    private Date time;

    public TrackMetadataVM() {
    }

    public TrackMetadataVM(String name, String description, String author, Link link, Date time) {
        this.name = name;
        this.desc = description;
        this.author = author;
        this.link = link;
        this.time = time;
    }

    /* Getter and Setter */

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
