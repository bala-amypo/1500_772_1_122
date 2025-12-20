package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@Tag(name = "Sales Transactions")
public class SaleTransactionController {

    private final SaleTransactionService service;

    public SaleTransactionController(SaleTransactionService service) {
        this.service = service;
    }

    @PostMapping
    public SaleTransaction create(@RequestBody SaleTransaction tx) {
        return service.createSale(tx);
    }

    @GetMapping("/code/{discountCodeId}")
    public List<SaleTransaction> byCode(@PathVariable Long discountCodeId) {
        return service.getSalesForCode(discountCodeId);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<SaleTransaction> byInfluencer(@PathVariable Long influencerId) {
        return service.getSalesForInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<SaleTransaction> byCampaign(@PathVariable Long campaignId) {
        return service.getSalesForCampaign(campaignId);
    }
}
