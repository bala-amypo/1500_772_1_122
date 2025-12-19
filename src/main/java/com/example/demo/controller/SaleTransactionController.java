package com.example.demo.controller;

import com.example.demo.entity.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/saleTransactions")
public class SaleTransactionController {

    @Autowired
    private SaleTransactionService saleTransactionService;

    // Create
    @PostMapping
    public SaleTransaction addTransaction(@RequestBody SaleTransaction transaction) {
        return saleTransactionService.saveTransaction(transaction);
    }

    // Get all
    @GetMapping
    public List<SaleTransaction> getAllTransactions() {
        return saleTransactionService.getAllTransactions();
    }

    // Get by ID
    @GetMapping("/{id}")
    public Optional<SaleTransaction> getTransaction(@PathVariable Long id) {
        return saleTransactionService.getTransactionById(id);
    }

    // Update
    @PutMapping
    public SaleTransaction updateTransaction(@RequestBody SaleTransaction transaction) {
        return saleTransactionService.updateTransaction(transaction);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        saleTransactionService.deleteTransaction(id);
    }
}
