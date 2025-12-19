package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.SaleTransaction;

public interface SaleTransactionRepository extends JpaRepository<SaleTransaction, Long> {
    // You can add custom query methods here if needed
}
