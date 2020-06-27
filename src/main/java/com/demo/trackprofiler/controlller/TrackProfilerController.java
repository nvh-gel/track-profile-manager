package com.demo.trackprofiler.controlller;

import com.demo.trackprofiler.domain.viewmodel.TrackVM;
import com.demo.trackprofiler.service.TrackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

/**
 * Rest Controller for API to upload, view details, view list of tracks
 */
@RestController
@RequestMapping(value = "api/track")
public class TrackProfilerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrackProfilerController.class);

    @Autowired
    TrackService trackService;

    /**
     * API to upload gpx file and process the data
     *
     * @param file file to upload
     * @return String to represent the upload status
     */
    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadTrack(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return new ResponseEntity<>("PLease select a valid gpx file to upload.", HttpStatus.BAD_REQUEST);
        }
        try {
            trackService.processUploadedFile(file);
            return new ResponseEntity<>("You successfully uploaded '" + file.getOriginalFilename() + "'", HttpStatus.ACCEPTED);
        } catch (IOException exception) {
            LOGGER.error(exception.getMessage());
            return new ResponseEntity<>("Internal server error: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (JAXBException exception) {
            LOGGER.error(exception.getMessage());
            return new ResponseEntity<>("Internal server error when processing gpx file: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get details info of a track.
     *
     * @param trackId track ID
     * @return track info if found, or else return http code 404
     */
    @GetMapping("/{id}")
    public ResponseEntity<TrackVM> getTrackDetails(@PathVariable(value = "id") Integer trackId) {
        TrackVM trackVM = trackService.findTrackById(trackId);

        if (trackVM != null) {
            return new ResponseEntity<>(trackVM, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Get list of tracks in database.
     *
     * @return list of retrieved tracks
     */
    @GetMapping
    public ResponseEntity<List<TrackVM>> getRecentTracks() {
        List<TrackVM> tracks = trackService.findAllTracks();

        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }
}
