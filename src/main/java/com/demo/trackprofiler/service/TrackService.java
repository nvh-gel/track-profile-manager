package com.demo.trackprofiler.service;

import com.demo.trackprofiler.domain.viewmodel.TrackListVM;
import com.demo.trackprofiler.domain.viewmodel.TrackVM;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface TrackService {
    TrackListVM findAllTracks();

    TrackVM findTrackById(Integer trackId);

    void processUploadedFile(MultipartFile file) throws IOException, JAXBException;
}
