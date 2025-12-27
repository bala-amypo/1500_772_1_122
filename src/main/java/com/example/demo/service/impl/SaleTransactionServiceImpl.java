package com.example.demo.service;

import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.SaleTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    @Autowired
    private SaleTransactionRepository saleTransactionRepository;

    @Override
    public List<SaleTransaction> getAllTransactions() {
        return saleTransactionRepository.findAll();
    }

    @Override
    public SaleTransaction getTransactionById(Long id) {
        return saleTransactionRepository.findById(id).orElse(null);
    }

    @Override
    public SaleTransaction updateTransaction(Long id, SaleTransaction transaction) {
        SaleTransaction existing = saleTransactionRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setTransactionId(transaction.getTransactionId());
            existing.setProductName(transaction.getProductName());
            existing.setQuantity(transaction.getQuantity());
            existing.setTotalPrice(transaction.getTotalPrice());
            return saleTransactionRepository.save(existing);
        }
        return null;
    }
}
