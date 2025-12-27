package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DiscountCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeValue;
    private Double discountPercentage;

    @ManyToOne
    private Influencer influencer;

    @ManyToOne
    private Campaign campaign;

    public DiscountCode() {}

    public DiscountCode(String codeValue, Double discountPercentage) {
        this.codeValue = codeValue;
        this.discountPercentage = discountPercentage;
    }

    public Long getId() { return id; }
    public String getCodeValue() { return codeValue; }
    public Double getDiscountPercentage() { return discountPercentage; }
    public Influencer getInfluencer() { return influencer; }
    public Campaign getCampaign() { return campaign; }

    public void setId(Long id) { this.id = id; }
    public void setCodeValue(String codeValue) { this.codeValue = codeValue; }
    public void setDiscountPercentage(Double discountPercentage) { this.discountPercentage = discountPercentage; }
    public void setInfluencer(Influencer influencer) { this.influencer = influencer; }
    public void setCampaign(Campaign campaign) { this.campaign = campaign; }
}
