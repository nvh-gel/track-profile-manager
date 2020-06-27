package com.demo.trackprofiler.domain.repository;

import com.demo.trackprofiler.domain.model.TrackPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CRUD repos for TrackPoint
 */
@Repository
public interface TrackPointRepository extends CrudRepository<TrackPoint, Integer> {

    /**
     * Find all track points that has specific track_id
     *
     * @param trackId requested track_id
     * @return list of all track points have track_id matched
     */
    List<TrackPoint> findTrackPointsByTrackId(Integer trackId);
}
