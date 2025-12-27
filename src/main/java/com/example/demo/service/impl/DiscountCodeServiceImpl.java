package com.example.demo.service;

import com.example.demo.model.DiscountCode;
import com.example.demo.repository.DiscountCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    @Autowired
    private DiscountCodeRepository discountCodeRepository;

    @Override
    public List<DiscountCode> getAllDiscountCodes() {
        return discountCodeRepository.findAll();
    }

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return discountCodeRepository.findById(id).orElse(null);
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode discountCode) {
        DiscountCode existing = discountCodeRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCode(discountCode.getCode());
            existing.setDiscountPercentage(discountCode.getDiscountPercentage());
            return discountCodeRepository.save(existing);
        }
        return null;
    }
}
