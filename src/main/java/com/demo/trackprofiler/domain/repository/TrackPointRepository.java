package com.demo.trackprofiler.domain.repository;

import com.demo.trackprofiler.domain.model.TrackPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackPointRepository extends JpaRepository<TrackPoint, Integer> {

    @Query("SELECT trackPointId, trackId, latitude, longitude, elevation, time FROM TrackPoint WHERE trackId = ?1")
    List<TrackPoint> findAllByTrackId(Integer trackId);
}
