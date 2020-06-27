package com.demo.trackprofiler.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Mock controller for upload file page
 */
@Controller
public class TrackUploadController {

    /**
     * Upload page
     *
     * @return string reference to upload page
     */
    @GetMapping("/")
    public String mockUpload() {
        return "upload";
    }
}
