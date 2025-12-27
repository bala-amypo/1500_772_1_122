package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;

public interface DiscountCodeService {
    DiscountCode createDiscountCode(DiscountCode discountCode);
    List<DiscountCode> getAllDiscountCodes();
    DiscountCode getDiscountCodeById(Long id);
}
