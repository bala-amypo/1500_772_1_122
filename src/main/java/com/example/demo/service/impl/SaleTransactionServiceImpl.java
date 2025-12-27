package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    @Override
    public SaleTransaction createSale(SaleTransaction transaction) {
        if (transaction.getTransactionAmount() != null &&
            transaction.getTransactionAmount().signum() <= 0) {
            throw new IllegalArgumentException("Transaction amount must be > 0");
        }
        return transaction;
    }

    @Override
    public List<SaleTransaction> getSalesForCode(Long discountCodeId) {
        return new ArrayList<>();
    }

    @Override
    public List<SaleTransaction> getSalesForInfluencer(Long influencerId) {
        return new ArrayList<>();
    }

    @Override
    public List<SaleTransaction> getSalesForCampaign(Long campaignId) {
        return new ArrayList<>();
    }
}
