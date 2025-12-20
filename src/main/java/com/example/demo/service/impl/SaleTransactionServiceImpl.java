package com.example.demo.service.impl;

import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.SaleTransactionRepository;
import com.example.demo.service.SaleTransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        if (transaction.getTransactionDate() == null) {
            transaction.setTransactionDate(LocalDate.now());
        }
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
        return repository.findById(id).map(tx -> {
            tx.setDiscountCodeId(updated.getDiscountCodeId());
            tx.setTransactionAmount(updated.getTransactionAmount());
            tx.setCustomerId(updated.getCustomerId());
            tx.setTransactionDate(updated.getTransactionDate() != null ? updated.getTransactionDate() : LocalDate.now());
            return repository.save(tx);
        }).orElse(null);
    }

    @Override
    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    }
}
