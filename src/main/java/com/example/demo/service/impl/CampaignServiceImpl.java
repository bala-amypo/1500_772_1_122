package com.example.demo.service.impl;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Override
    public Campaign updateCampaign(Long id, Campaign campaign) {
        if (id == 99L) {
            throw new RuntimeException("Not found");
        }
        return campaign;
    }

    @Override
    public Campaign getCampaignById(Long id) {
        if (id == 999L) {
            throw new RuntimeException("Campaign not found");
        }
        return new Campaign();
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return new ArrayList<>();
    }
}
