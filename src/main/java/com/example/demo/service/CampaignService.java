package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Campaign;

public interface CampaignService {

    Campaign createCampaign(Campaign campaign);

    Campaign updateCampaign(Long id, Campaign campaign);

    Campaign getCampaignById(Long id);

    List<Campaign> getAllCampaigns();

    void deactivateCampaign(Long id);
}
