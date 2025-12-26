package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DiscountCode;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository repository;

    public DiscountCodeServiceImpl(DiscountCodeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DiscountCode> getAllDiscountCodes() {
        return repository.findAll();
    }

    @Override
    public DiscountCode getDiscountCodeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DiscountCode not found"));
    }

    @Override
    public DiscountCode updateDiscountCode(Long id, DiscountCode discountCode) {
        DiscountCode existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DiscountCode not found"));

        existing.setCode(discountCode.getCode());
        existing.setDiscountPercentage(discountCode.getDiscountPercentage());

        return repository.save(existing);
    }
}
