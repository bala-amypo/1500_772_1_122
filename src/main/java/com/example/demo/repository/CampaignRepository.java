package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.CampaignEntity;

public interface CampaignRepository extends JpaRepository<CampaignEntity, Long> {
}
