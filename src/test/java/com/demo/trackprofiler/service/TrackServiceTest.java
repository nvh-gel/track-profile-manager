package com.demo.trackprofiler.service;

import com.demo.trackprofiler.domain.model.Track;
import com.demo.trackprofiler.domain.model.TrackPoint;
import com.demo.trackprofiler.domain.model.Waypoint;
import com.demo.trackprofiler.domain.repository.TrackRepository;
import com.demo.trackprofiler.domain.viewmodel.TrackMetadataVM;
import com.demo.trackprofiler.domain.viewmodel.TrackVM;
import com.demo.trackprofiler.utils.Link;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrackServiceTest {

    @MockBean
    private TrackRepository trackRepository;

    @Autowired
    private TrackService trackService;

    @Test
    public void testFindAllTracksEmpty() throws Exception {
        List<Track> tracks = Collections.emptyList();
        given(trackRepository.findAllByOrderByTimeDesc()).willReturn(tracks);

        List<TrackVM> trackVMS = trackService.findAllTracks();
        Assert.assertTrue(trackVMS.isEmpty());
    }

    @Test
    public void testFindAllTracksWithData() throws Exception {
        List<Track> tracks = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        Track track = new Track(1, "testTrack", "testDesc", "testAuthor", "testURL", "testText", now);
        tracks.add(track);
        given(trackRepository.findAllByOrderByTimeDesc()).willReturn(tracks);

        List<TrackVM> trackVMS = trackService.findAllTracks();
        Assert.assertEquals(1, trackVMS.size());
        TrackVM returnedVM = trackVMS.get(0);

        TrackVM expectedReturn = new TrackVM();
        expectedReturn.setTrackSegments(null);
        expectedReturn.setTrackId(1);
        expectedReturn.setWaypoints(null);

        Date expectedTime = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        Link expectedLink = new Link("testURL", "testText");
        TrackMetadataVM expectedMetadata = new TrackMetadataVM("testTrack", "testDesc", "testAuthor", expectedLink, expectedTime);

        Assert.assertEquals(expectedReturn.getTrackId(), returnedVM.getTrackId());
        Assert.assertTrue(expectedMetadata.isEqual(returnedVM.getMetadata()));
        Assert.assertEquals(expectedReturn.getTrackSegments(), returnedVM.getTrackSegments());
        Assert.assertEquals(expectedReturn.getWaypoints(), returnedVM.getWaypoints());
    }

    @Test
    public void testFindSingleNotFound() throws Exception {
        Track track = null;
        given(trackRepository.findOne(999)).willReturn(track);

        TrackVM trackVM = trackService.findTrackById(999);
        Assert.assertNull(trackVM);
    }

    @Test
    public void testFindSingleFound() throws Exception {
        Track track = new Track();
        track.setTrackId(1);
        track.setName("testName");
        track.setDescription("testDescription");
        track.setAuthor("");
        track.setUrl("testURL");
        track.setUrlText("testText");
        LocalDateTime now = LocalDateTime.now();
        track.setTime(now);

        TrackPoint tp = new TrackPoint();
        tp.setTrackPointId(1);
        tp.setTrackId(1);
        tp.setLatitude(BigDecimal.valueOf(1.2f));
        tp.setLongitude(BigDecimal.valueOf(1.3f));
        tp.setElevation(BigDecimal.valueOf(1.4f));
        tp.setTime(now);
        track.setTrackPoints(Lists.newArrayList(tp));

        Waypoint wp = new Waypoint();
        wp.setWaypointId(1);
        wp.setTrackId(1);
        wp.setLatitude(BigDecimal.valueOf(3.3f));
        wp.setLongitude(BigDecimal.valueOf(3.4f));
        wp.setName("testWP");
        wp.setSymbol("testSym");
        track.setWaypoints(Lists.newArrayList(wp));

        given(trackRepository.findOne(1)).willReturn(track);

        TrackVM returned = trackService.findTrackById(1);

        Assert.assertNotNull(returned);
    }

    @Test
    public void testUploadFile() throws Exception {
        TrackRepository mockRepository = Mockito.mock(TrackRepository.class);
        TrackService mockService = Mockito.mock(TrackService.class);

        File file = new File("src/test/resources/test.gpx");
        FileInputStream fip = new FileInputStream(file);
        MultipartFile mtpFile = new MockMultipartFile("test.gpx", "test.gpx", "", fip);
        trackService.processUploadedFile(mtpFile);

        Track savedTrack = new Track();
        savedTrack.setTrackId(1);

        File uploaded = new File("D:\\temp\test.gpx");
        Assert.assertTrue(uploaded.exists());

//        verify(trackRepository.save(Mockito.any(Track.class))).willReturn(savedTrack);
        // WIP mock repository save actions
    }
}
