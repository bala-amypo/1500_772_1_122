package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount-codes")
@Tag(name = "Discount Codes")
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


    private final DiscountCodeService discountCodeService;

    public DiscountCodeController(DiscountCodeService discountCodeService) {
        this.discountCodeService = discountCodeService;
    }

    @Operation(summary = "Get all discount codes")
    @GetMapping
    public List<DiscountCode> getAllDiscountCodes() {
        return discountCodeService.getAllDiscountCodes();
    }

    @Operation(summary = "Get a discount code by ID")
    @GetMapping("/{id}")
    public DiscountCode getDiscountCodeById(@PathVariable Long id) {
        return discountCodeService.getDiscountCodeById(id)
                .orElseThrow(() -> new RuntimeException("DiscountCode not found"));
    }

    @Operation(summary = "Create a new discount code")
    @PostMapping
    public DiscountCode createDiscountCode(@RequestBody DiscountCode discountCode) {
        return discountCodeService.createDiscountCode(discountCode);
    }

    @Operation(summary = "Update an existing discount code")
    @PutMapping("/{id}")
    public DiscountCode updateDiscountCode(@PathVariable Long id, @RequestBody DiscountCode discountCode) {
        return discountCodeService.updateDiscountCode(id, discountCode);
    }

    @Operation(summary = "Delete a discount code by ID")
    @DeleteMapping("/{id}")
    public void deleteDiscountCode(@PathVariable Long id) {
        discountCodeService.deleteDiscountCode(id);
    }
}
