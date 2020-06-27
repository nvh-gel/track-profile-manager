package com.demo.trackprofiler.controlller;

import com.demo.trackprofiler.domain.viewmodel.TrackListVM;
import com.demo.trackprofiler.domain.viewmodel.TrackVM;
import com.demo.trackprofiler.service.TrackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@RestController
@RequestMapping(value = "api/track")
public class TrackProfilerController {

    @Autowired
    TrackService trackService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TrackProfilerController.class);



    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadTrack(@RequestParam("file") MultipartFile file,
                                              RedirectAttributes redirectAttributes) throws IOException, JAXBException {

        if (file.isEmpty()) {
            return new ResponseEntity<>("PLease seclect a valid gpx file to upload.", HttpStatus.BAD_REQUEST);
        }
        try {
            trackService.processUploadedFile(file);
            return new ResponseEntity<>("You successfully uploaded '" + file.getOriginalFilename() + "'", HttpStatus.ACCEPTED);
        } catch(Exception exception) {
            LOGGER.error(exception.getMessage());
            throw exception;
//            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackVM> getTrackDetails(@PathVariable(value = "id") Integer trackId) {
        return new ResponseEntity<>(trackService.findTrackById(trackId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<TrackListVM> getRecentTracks(@RequestParam(value = "userId", required = false) Integer userId,
                                                       @RequestParam(value = "page", required = false) Integer page) {
        TrackListVM trackListVM = trackService.findAllTracks();

        return new ResponseEntity<>(trackListVM, HttpStatus.OK);
    }
}
