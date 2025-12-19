package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Campaign;
import com.example.demo.entity.DiscountCode;
import com.example.demo.entity.Influencer;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.service.DiscountCodeService;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository discountCodeRepository;
    private final InfluencerRepository influencerRepository;
    private final CampaignRepository campaignRepository;

    // REQUIRED constructor order (tests depend on this)
    public DiscountCodeServiceImpl(
            DiscountCodeRepository discountCodeRepository,
            InfluencerRepository influencerRepository,
            CampaignRepository campaignRepository) {

        this.discountCodeRepository = discountCodeRepository;
        this.influencerRepository = influencerRepository;
        this.campaignRepository = campaignRepository;
    }

    @Override
    public DiscountCode createDiscountCode(DiscountCode code) {

        discountCodeRepository.findByCode(code.getCode()).ifPresent(c -> {
            throw new RuntimeException("Discount code already exists");
        });

        Long influencerId = code.getInfluencer().getId();
        Long campaignId = code.getCampaign().getId();

        Influencer influencer = influencerRepository.findById(influencerId)
                .orElseThrow(() -> new RuntimeException("Influencer not found"));

        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        code.setInfluencer(influencer);
        code.setCampaign(campaign);

        return discountCodeRepository.save(code);
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode code) {

        DiscountCode existing = discountCodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Discount code not found"));

        existing.setCode(code.getCode());
        existing.setDiscountPercentage(code.getDiscountPercentage());
        existing.setActive(code.getActive());

        return discountCodeRepository.save(existing);
    }

    @Override
    public DiscountCode getCodeById(Long id) {
        return discountCodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Discount code not found"));
    }

    @Override
    public List<DiscountCode> getCodesByInfluencer(Long influencerId) {
        return discountCodeRepository.findAll()
                .stream()
                .filter(dc -> dc.getInfluencer().getId().equals(influencerId))
                .toList();
    }

    @Override
    public List<DiscountCode> getCodesByCampaign(Long campaignId) {
        return discountCodeRepository.findAll()
                .stream()
                .filter(dc -> dc.getCampaign().getId().equals(campaignId))
                .toList();
    }

    @Override
    public void deactivateCode(Long id) {
        DiscountCode code = discountCodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Discount code not found"));

        code.setActive(false);
        discountCodeRepository.save(code);
    }
}
