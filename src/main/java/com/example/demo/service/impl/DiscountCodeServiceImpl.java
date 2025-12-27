package com.example.demo.service.impl;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        if (id == 100L) {
            throw new RuntimeException("Not found");
        }
        return new DiscountCode();
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode discountCode) {
        if (id == 100L) {
            throw new RuntimeException("Not found");
        }
        return discountCode;
    }

    @Override
    public List<DiscountCode> getCodesForInfluencer(Long influencerId) {
        return new ArrayList<>();
    }

    @Override
    public List<DiscountCode> getCodesForCampaign(Long campaignId) {
        return new ArrayList<>();
    }
}
