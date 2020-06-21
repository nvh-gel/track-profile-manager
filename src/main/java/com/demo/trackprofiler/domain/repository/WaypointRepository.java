package com.demo.trackprofiler.domain.repository;

import com.demo.trackprofiler.domain.model.Waypoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaypointRepository extends JpaRepository<Waypoint, Integer> {
}
