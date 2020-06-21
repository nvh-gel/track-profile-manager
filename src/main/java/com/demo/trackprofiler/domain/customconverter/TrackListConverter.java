package com.demo.trackprofiler.domain.customconverter;

import com.demo.trackprofiler.domain.model.Track;
import com.demo.trackprofiler.domain.viewmodel.TrackListVM;
import com.demo.trackprofiler.domain.viewmodel.TrackVM;
import com.demo.trackprofiler.utils.Link;
import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class TrackListConverter implements CustomConverter {

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Override
    public Object convert(Object dest, Object src, Class<?> aClass, Class<?> bClass) {
        if (src == null) {
            return null;
        }
        if (src instanceof List && dest instanceof TrackListVM) {
            List<Track> trackList = (List<Track>) src;

            List<TrackVM> trackVMList = trackList.stream().map(track -> {
                if (track != null) {
                    TrackVM trackVM = new TrackVM();
                    dozerBeanMapper.map(track, trackVM);
                    trackVM.setLink(dozerBeanMapper.map(track, Link.class));
                    return trackVM;
                } else {
                    return null;
                }
            }).collect(Collectors.toList());

            ((TrackListVM) dest).setTracks(trackVMList);
            return dest;
        }
        return null;
    }

    public DozerBeanMapper getDozerBeanMapper() {
        return dozerBeanMapper;
    }

    public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper) {
        this.dozerBeanMapper = dozerBeanMapper;
    }
}
