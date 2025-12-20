package com.example.demo.service;

import com.example.demo.model.SaleTransaction;
import java.util.List;
import java.util.Optional;

public interface SaleTransactionService {
    SaleTransaction createTransaction(SaleTransaction transaction);
    List<SaleTransaction> getAllTransactions();
    Optional<SaleTransaction> getTransactionById(Long id);
    SaleTransaction updateTransaction(Long id, SaleTransaction updated);
    void deleteTransaction(Long id);
}
