package com.demo.trackprofiler.service;

import com.demo.trackprofiler.domain.viewmodel.TrackVM;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

/**
 * Interface for handling business logic for tracks
 */
public interface TrackService {

    /**
     * Retrieve all tracks in database and return to user.
     *
     * @return list of tracks
     */
    List<TrackVM> findAllTracks();

    /**
     * Retrieve details of a single track in database and return to user.
     *
     * @param trackId requested track id
     * @return track detail information
     */
    TrackVM findTrackById(Integer trackId);

    /**
     * Process an uploaded file from user and add a record to database
     *
     * @param file uploaded file
     * @throws IOException   if there is IO issue when processing file
     * @throws JAXBException if there is XML processing issue
     */
    void processUploadedFile(MultipartFile file) throws IOException, JAXBException;
}
