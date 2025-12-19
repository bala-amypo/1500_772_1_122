package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CampaignEntity;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.service.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public CampaignEntity addCampaign(CampaignEntity campaign) {
        return campaignRepository.save(campaign);
    }

    @Override
    public List<CampaignEntity> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    @Override
    public CampaignEntity getCampaignById(Long id) {
        return campaignRepository.findById(id).orElse(null);
    }

    @Override
    public CampaignEntity updateCampaign(Long id, CampaignEntity campaign) {
        CampaignEntity existing = campaignRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCampaignName(campaign.getCampaignName());
            existing.setBrand(campaign.getBrand());
            existing.setBudget(campaign.getBudget());
            existing.setStartDate(campaign.getStartDate());
            existing.setEndDate(campaign.getEndDate());
            return campaignRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteCampaign(Long id) {
        campaignRepository.deleteById(id);
    }
}
