package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;

public interface CampaignService {
    Campaign createCampaign(Campaign campaign);
    List<Campaign> getAllCampaigns();
    Campaign getCampaignById(Long id);
}
