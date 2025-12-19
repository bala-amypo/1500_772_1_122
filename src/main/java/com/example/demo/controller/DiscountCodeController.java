package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService discountCodeService;

    public DiscountCodeController(DiscountCodeService discountCodeService) {
        this.discountCodeService = discountCodeService;
    }

    @GetMapping
    public List<DiscountCode> getAllDiscountCodes() {
        return discountCodeService.getAllDiscountCodes();
    }

    @GetMapping("/{id}")
    public DiscountCode getDiscountCodeById(@PathVariable Long id) {
        // Unwrap Optional
        return discountCodeService.getDiscountCodeById(id)
                .orElseThrow(() -> new RuntimeException("DiscountCode not found"));
    }

    @PostMapping
    public DiscountCode createDiscountCode(@RequestBody DiscountCode discountCode) {
        return discountCodeService.createDiscountCode(discountCode);
    }

    @PutMapping("/{id}")
    public DiscountCode updateDiscountCode(@PathVariable Long id, @RequestBody DiscountCode discountCode) {
        return discountCodeService.updateDiscountCode(id, discountCode);
    }

    @DeleteMapping("/{id}")
    public void deleteDiscountCode(@PathVariable Long id) {
        discountCodeService.deleteDiscountCode(id);
    }
}
