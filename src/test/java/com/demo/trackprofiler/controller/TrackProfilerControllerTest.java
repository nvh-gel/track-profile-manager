package com.demo.trackprofiler.controller;

import com.demo.trackprofiler.controlller.TrackProfilerController;
import com.demo.trackprofiler.domain.viewmodel.TrackMetadataVM;
import com.demo.trackprofiler.domain.viewmodel.TrackVM;
import com.demo.trackprofiler.service.TrackService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(TrackProfilerController.class)
public class TrackProfilerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrackService trackService;


    @Test
    public void testRetrieveLatestTracks() throws Exception {
        List<TrackVM> trackVMS = new ArrayList<>();
        TrackVM trackVM = new TrackVM();
        trackVM.setTrackId(1);
        TrackMetadataVM expectedMetadata = new TrackMetadataVM("testTrack", "testDesc", "testAuthor", null, new Date());
        trackVM.setMetadata(expectedMetadata);
        trackVMS.add(trackVM);

        given(trackService.findAllTracks()).willReturn(trackVMS);

        mockMvc.perform(get("/api/track")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].trackId", is(trackVM.getTrackId())));
    }
}
