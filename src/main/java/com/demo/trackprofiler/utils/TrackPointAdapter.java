package com.demo.trackprofiler.utils;

import com.demo.trackprofiler.domain.model.TrackPoint;
import com.demo.trackprofiler.domain.viewmodel.TrackPointVM;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TrackPointAdapter extends XmlAdapter<String, TrackPointVM> {

    @Override
    public TrackPointVM unmarshal(String v) throws Exception {
        System.out.println("test unmarshall");
        return null;
    }

    @Override
    public String marshal(TrackPointVM v) throws Exception {
        System.out.println("test marshal");
        return null;
    }
}
