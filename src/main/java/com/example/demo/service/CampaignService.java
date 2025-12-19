package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CampaignEntity;

public interface CampaignService {

    CampaignEntity addCampaign(CampaignEntity campaign);

    List<CampaignEntity> getAllCampaigns();

    CampaignEntity getCampaignById(Long id);

    CampaignEntity updateCampaign(Long id, CampaignEntity campaign);

    void deleteCampaign(Long id);
}
