package com.demo.trackprofiler;

import com.demo.trackprofiler.controlller.TrackProfilerController;
import com.demo.trackprofiler.controlller.TrackUploadController;
import com.demo.trackprofiler.service.TrackService;
import com.demo.trackprofiler.service.impl.TrackServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    ApplicationContext ac;
    @Autowired
    private TrackProfilerController trackProfilerController;
    @Autowired
    private TrackUploadController trackUploadController;

    @Test
    public void contextLoads() throws Exception {
        TrackService trackService = ac.getBean(TrackService.class);
        Assert.assertTrue(trackService instanceof TrackServiceImpl);

        Assert.assertNotNull(trackProfilerController);
        Assert.assertNotNull(trackUploadController);
    }

}
