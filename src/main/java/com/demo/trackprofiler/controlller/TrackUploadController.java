package com.demo.trackprofiler.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TrackUploadController {

    @GetMapping("/")
    public String mockUpload() {
        return "upload";
    }
}
