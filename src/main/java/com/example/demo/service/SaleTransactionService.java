package com.example.demo.service;

import com.example.demo.model.DiscountCode;
import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.DiscountCodeRepository;
import com.example.demo.repository.SaleTransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class SaleTransactionService {

    private final SaleTransactionRepository saleRepo;
    private final DiscountCodeRepository codeRepo;

    public SaleTransactionService(
            SaleTransactionRepository saleRepo,
            DiscountCodeRepository codeRepo) {
        this.saleRepo = saleRepo;
        this.codeRepo = codeRepo;
    }

    public SaleTransaction create(SaleTransaction saleTransaction) {

        if (saleTransaction.getDiscountCode() == null ||
            saleTransaction.getDiscountCode().getId() == null) {
            throw new RuntimeException("DiscountCode ID is required");
        }

        DiscountCode code = codeRepo.findById(
                saleTransaction.getDiscountCode().getId()
        ).orElseThrow(() -> new RuntimeException("DiscountCode not found"));

        saleTransaction.setDiscountCode(code);
        return saleRepo.save(saleTransaction);
    }
}
