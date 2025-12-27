package com.example.demo.service;

import com.example.demo.model.SaleTransaction;
import java.util.List;

public interface SaleTransactionService {
    List<SaleTransaction> getAllTransactions();
    SaleTransaction getTransactionById(Long id);
    SaleTransaction updateTransaction(Long id, SaleTransaction transaction);
}
