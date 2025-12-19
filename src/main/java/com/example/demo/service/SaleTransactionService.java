package com.example.demo.service;

import com.example.demo.model.SaleTransaction;
import com.example.demo.repository.SaleTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleTransactionService {

    private final SaleTransactionRepository repository;

    public SaleTransactionService(SaleTransactionRepository repository) {
        this.repository = repository;
    }

    public SaleTransaction create(SaleTransaction saleTransaction) {
        return repository.save(saleTransaction);
    }

    public List<SaleTransaction> getAll() {
        return repository.findAll();
    }

    public SaleTransaction getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("SaleTransaction not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}