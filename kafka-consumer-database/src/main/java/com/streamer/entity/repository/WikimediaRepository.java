package com.streamer.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.streamer.entity.Wikimedia;

@Repository
public interface WikimediaRepository extends JpaRepository<Wikimedia, Long> {

}
