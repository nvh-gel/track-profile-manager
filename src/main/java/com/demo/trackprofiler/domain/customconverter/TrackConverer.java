package com.demo.trackprofiler.domain.customconverter;

import com.demo.trackprofiler.domain.viewmodel.TrackVM;
import org.dozer.CustomConverter;

public class TrackConverer implements CustomConverter {
    @Override
    public Object convert(Object dest, Object src, Class<?> aClass, Class<?> bClass) {
        if (src == null) {
            return null;
        }
        if (src instanceof TrackVM) {
            TrackVM trackVM = new TrackVM();

        }
        return null;
    }
}
