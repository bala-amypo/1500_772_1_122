package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CampaignEntity;
import com.example.demo.service.CampaignService;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @PostMapping
    public CampaignEntity createCampaign(@RequestBody CampaignEntity campaign) {
        return campaignService.addCampaign(campaign);
    }

    @GetMapping
    public List<CampaignEntity> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/{id}")
    public CampaignEntity getCampaignById(@PathVariable Long id) {
        return campaignService.getCampaignById(id);
    }

    @PutMapping("/{id}")
    public CampaignEntity updateCampaign(
            @PathVariable Long id,
            @RequestBody CampaignEntity campaign) {
        return campaignService.updateCampaign(id, campaign);
    }

    @DeleteMapping("/{id}")
    public String deleteCampaign(@PathVariable Long id) {
        campaignService.deleteCampaign(id);
        return "Campaign deleted successfully";
    }
}
