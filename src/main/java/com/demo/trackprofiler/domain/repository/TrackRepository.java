package com.demo.trackprofiler.domain.repository;

import com.demo.trackprofiler.domain.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {}
