package com.example.project.repository;

import com.example.project.entity.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InfluencerRepository extends JpaRepository<Influencer, Long> {
    Optional<Influencer> findBySocialHandle(String socialHandle);
}
