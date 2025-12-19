package com.example.demo.controller;

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale-transactions")
@Tag(name = "Sale Transactions")
public class SaleTransactionController {

    private final SaleTransactionService service;

    public SaleTransactionController(SaleTransactionService service) {
        this.service = service;
    }

    @PostMapping
    public SaleTransaction create(@RequestBody SaleTransaction saleTransaction) {
        return service.create(saleTransaction);
    }

    @GetMapping
    public List<SaleTransaction> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SaleTransaction getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}