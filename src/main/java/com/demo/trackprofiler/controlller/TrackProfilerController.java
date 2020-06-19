package com.demo.trackprofiler.controlller;

import com.demo.trackprofiler.domain.viewmodel.TrackListVM;
import com.demo.trackprofiler.domain.viewmodel.TrackVM;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/track")
public class TrackProfilerController {


    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadTrack() {
        return new ResponseEntity<>("Uploaded successfully.", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackVM> getTrackDetails(@PathVariable(value = "id") Integer trackId) {
        return new ResponseEntity<>(new TrackVM(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<TrackListVM> getRecentTracks(@RequestParam(value = "userId", required = false) Integer userId,
                                                       @RequestParam(value = "page", required = false) Integer page) {
        return new ResponseEntity<>(new TrackListVM(), HttpStatus.OK);
    }


}
