package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discountcodes")
@Tag(name = "Discount Codes", description = "APIs for managing discount codes linked to influencers and campaigns")
public class DiscountCodeController {

    @Autowired
    private DiscountCodeService discountCodeService;

    @Operation(summary = "Get all discount codes")
    @GetMapping
    public ResponseEntity<List<DiscountCode>> getAllDiscountCodes() {
        List<DiscountCode> discountCodes = discountCodeService.getAllDiscountCodes();
        return ResponseEntity.ok(discountCodes);
    }

    @Operation(summary = "Get a discount code by ID")
    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> getDiscountCodeById(@PathVariable Long id) {
        return ResponseEntity.ok(discountCodeService.getDiscountCodeById(id));
    }

    @Operation(summary = "Create a new discount code")
    @PostMapping
    public ResponseEntity<DiscountCode> createDiscountCode(@RequestBody DiscountCode discountCode) {
        DiscountCode created = discountCodeService.createDiscountCode(discountCode);
        return ResponseEntity.ok(created);
    }

    @Operation(summary = "Update an existing discount code")
    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> updateDiscountCode(@PathVariable Long id, @RequestBody DiscountCode discountCode) {
        DiscountCode updated = discountCodeService.updateDiscountCode(id, discountCode);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Delete a discount code by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscountCode(@PathVariable Long id) {
        discountCodeService.deleteDiscountCode(id);
        return ResponseEntity.noContent().build();
    }
}
