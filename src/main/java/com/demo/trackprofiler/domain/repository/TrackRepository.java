package com.demo.trackprofiler.domain.repository;

import com.demo.trackprofiler.domain.model.Track;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD repos for Track
 */
@Repository
public interface TrackRepository extends CrudRepository<Track, Integer> {
}
