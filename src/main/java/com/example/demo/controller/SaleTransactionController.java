package com.example.demo.controller; // <-- package added

import com.example.demo.model.SaleTransaction;
import com.example.demo.service.SaleTransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saletransactions")
@Tag(name = "SaleTransaction", description = "APIs related to SaleTransaction") // Swagger heading
public class SaleTransactionController {

    @Autowired
    private SaleTransactionService saleTransactionService;

    @GetMapping
    public ResponseEntity<List<SaleTransaction>> getAllTransactions() {
        return ResponseEntity.ok(saleTransactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleTransaction> getTransactionById(@PathVariable Long id) {
        SaleTransaction transaction = saleTransactionService.getTransactionById(id);
        if (transaction == null) transaction = new SaleTransaction();
        return ResponseEntity.ok(transaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleTransaction> updateTransaction(@PathVariable Long id, @RequestBody SaleTransaction transaction) {
        SaleTransaction updated = saleTransactionService.updateTransaction(id, transaction);
        if (updated == null) updated = new SaleTransaction();
        return ResponseEntity.ok(updated);
    }
}
