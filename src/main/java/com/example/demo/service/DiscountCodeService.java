package com.example.demo.service;

import com.example.demo.model.DiscountCode;
import java.util.List;

public interface DiscountCodeService {
    List<DiscountCode> getAllDiscountCodes();
    DiscountCode getDiscountCodeById(Long id);
    DiscountCode updateDiscountCode(Long id, DiscountCode discountCode);
}
