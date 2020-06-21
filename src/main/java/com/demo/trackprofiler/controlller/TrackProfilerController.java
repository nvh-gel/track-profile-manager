package com.demo.trackprofiler.controlller;

import com.demo.trackprofiler.domain.model.Track;
import com.demo.trackprofiler.domain.viewmodel.TrackListVM;
import com.demo.trackprofiler.domain.viewmodel.TrackVM;
import com.demo.trackprofiler.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/track")
public class TrackProfilerController {

    @Autowired
    TrackService trackService;


    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadTrack() {
        return new ResponseEntity<>("Uploaded successfully.", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackVM> getTrackDetails(@PathVariable(value = "id") Integer trackId) {
        return new ResponseEntity<>(trackService.findTrackById(trackId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<TrackListVM> getRecentTracks(@RequestParam(value = "userId", required = false) Integer userId,
                                                       @RequestParam(value = "page", required = false) Integer page) {
        return new ResponseEntity<>(new TrackListVM(), HttpStatus.OK);
    }

    @GetMapping(value = "/test")
    public ResponseEntity<List<Track>> getTrackModels() {
        return new ResponseEntity<>(trackService.findAllTrackModels(), HttpStatus.OK);
    }
}
