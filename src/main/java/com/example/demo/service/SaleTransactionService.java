package com.example.demo.service;

import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.SaleTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleTransactionService {

    private final SaleTransactionRepository repository;

    public SaleTransactionService(SaleTransactionRepository repository) {
        this.repository = repository;
    }

    public SaleTransaction createTransaction(SaleTransaction transaction) {
        return repository.save(transaction);
    }

    public List<SaleTransaction> getAllTransactions() {
        return repository.findAll();
    }

    public Optional<SaleTransaction> getTransactionById(Long id) {
        return repository.findById(id);
    }

    public SaleTransaction updateTransaction(Long id, SaleTransaction updated) {
        return repository.findById(id).map(tx -> {
            tx.setDiscountCodeId(updated.getDiscountCodeId());
            tx.setTransactionAmount(updated.getTransactionAmount());
            tx.setCustomerId(updated.getCustomerId());
            tx.setTransactionDate(updated.getTransactionDate());
            return repository.save(tx);
        }).orElse(null);
    }

    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }
}
