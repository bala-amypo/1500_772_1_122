package com.example.demo.service;

import com.example.demo.entity.SaleTransaction;
import com.example.demo.repository.SaleTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleTransactionService {

    @Autowired
    private SaleTransactionRepository saleTransactionRepository;

    // Create / Save
    public SaleTransaction saveTransaction(SaleTransaction transaction) {
        return saleTransactionRepository.save(transaction);
    }

    // Get all
    public List<SaleTransaction> getAllTransactions() {
        return saleTransactionRepository.findAll();
    }

    // Get by ID
    public Optional<SaleTransaction> getTransactionById(Long id) {
        return saleTransactionRepository.findById(id);
    }

    // Update
    public SaleTransaction updateTransaction(SaleTransaction transaction) {
        return saleTransactionRepository.save(transaction);
    }

    // Delete
    public void deleteTransaction(Long id) {
        saleTransactionRepository.deleteById(id);
    }
}
