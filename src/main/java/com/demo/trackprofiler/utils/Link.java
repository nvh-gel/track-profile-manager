package com.demo.trackprofiler.utils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * View class to hold the data for link of track
 */
public class Link {
    private String url;
    private String text;

    /*----------------------------------*
     Constructors
     *----------------------------------*/

    public Link() {
    }

    public Link(String url, String text) {
        this.url = url;
        this.text = text;
    }

    /*----------------------------------*
     Validation methods
     *----------------------------------*/

    public boolean isEqual(Link target) {
        return this.url.equals(target.url)
                && this.text.equals(target.text);
    }

    /*----------------------------------*
     Getters and Setters
     *----------------------------------*/

    @XmlAttribute(name = "href")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlElement(namespace = "http://www.topografix.com/GPX/1/1")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
