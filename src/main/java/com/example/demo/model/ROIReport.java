package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ROIReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long campaignId;
    private Double totalInvestment;
    private Double totalReturn;
    private Double roiPercentage;

    // Constructors
    public ROIReport() {}

    public ROIReport(Long id, Long campaignId, Double totalInvestment, Double totalReturn, Double roiPercentage) {
        this.id = id;
        this.campaignId = campaignId;
        this.totalInvestment = totalInvestment;
        this.totalReturn = totalReturn;
        this.roiPercentage = roiPercentage;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCampaignId() { return campaignId; }
    public void setCampaignId(Long campaignId) { this.campaignId = campaignId; }

    public Double getTotalInvestment() { return totalInvestment; }
    public void setTotalInvestment(Double totalInvestment) { this.totalInvestment = totalInvestment; }

    public Double getTotalReturn() { return totalReturn; }
    public void setTotalReturn(Double totalReturn) { this.totalReturn = totalReturn; }

    public Double getRoiPercentage() { return roiPercentage; }
    public void setRoiPercentage(Double roiPercentage) { this.roiPercentage = roiPercentage; }
}
