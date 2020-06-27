package com.demo.trackprofiler.utils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Link {
    private String url;
    private String text;

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
