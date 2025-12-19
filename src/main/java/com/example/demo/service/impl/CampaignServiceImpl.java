package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Campaign;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.service.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;

    // REQUIRED constructor (tests depend on this)
    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Campaign createCampaign(Campaign campaign) {

        if (campaign.getStartDate() != null && campaign.getEndDate() != null) {
            if (campaign.getStartDate().after(campaign.getEndDate())) {
                throw new RuntimeException("Invalid date range");
            }
        }

        if (campaign.getBudget() == null ||
                campaign.getBudget().compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Budget must be non-negative");
        }

        return campaignRepository.save(campaign);
    }

    @Override
    public Campaign updateCampaign(Long id, Campaign campaign) {

        Campaign existing = campaignRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        if (campaign.getStartDate() != null && campaign.getEndDate() != null) {
            if (campaign.getStartDate().after(campaign.getEndDate())) {
                throw new RuntimeException("Invalid date");
            }
        }

        existing.setCampaignName(campaign.getCampaignName());
        existing.setStartDate(campaign.getStartDate());
        existing.setEndDate(campaign.getEndDate());
        existing.setBudget(campaign.getBudget());

        return campaignRepository.save(existing);
    }

    @Override
    public Campaign getCampaignById(Long id) {
        return campaignRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    @Override
    public void deactivateCampaign(Long id) {
        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        campaign.setActive(false);
        campaignRepository.save(campaign);
    }
}
