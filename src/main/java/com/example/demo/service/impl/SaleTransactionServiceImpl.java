package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    private final SaleTransactionRepository repository;

    public SaleTransactionServiceImpl(SaleTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public SaleTransaction createTransaction(SaleTransaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public List<SaleTransaction> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public Optional<SaleTransaction> getTransactionById(Long id) {
        return repository.findById(id);
    }

    @Override
    public SaleTransaction updateTransaction(Long id, SaleTransaction updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setDiscountCodeId(updated.getDiscountCodeId());
                    existing.setTransactionAmount(updated.getTransactionAmount());
                    existing.setCustomerId(updated.getCustomerId());
                    existing.setTransactionDate(updated.getTransactionDate());
                    return repository.save(existing);
                })
                .orElseThrow();
    }

    @Override
    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }
}
