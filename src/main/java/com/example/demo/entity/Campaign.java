package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "campaign")
public class CampaignEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campaignId;

    private String campaignName;
    private String brand;
    private Double budget;
    private String startDate;
    private String endDate;

    // getters and setters
    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
