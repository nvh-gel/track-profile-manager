package com.demo.trackprofiler.domain.repository;

import com.demo.trackprofiler.domain.model.Waypoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CRUD repos for Waypoint
 */
@Repository
public interface WaypointRepository extends CrudRepository<Waypoint, Integer> {

    /**
     * Find all Waypoints in data base that have specific track_id
     *
     * @param trackId requested track_id
     * @return list of waypoints that have track_id matched
     */
    List<Waypoint> findWaypointsByTrackId(Integer trackId);
}
