package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class SaleTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long discountCodeId;  // flat field, no relationship

    private Double transactionAmount;

    private Long customerId;

    private LocalDate transactionDate = LocalDate.now(); // auto-fill current date

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getDiscountCodeId() { return discountCodeId; }
    public void setDiscountCodeId(Long discountCodeId) { this.discountCodeId = discountCodeId; }

    public Double getTransactionAmount() { return transactionAmount; }
    public void setTransactionAmount(Double transactionAmount) { this.transactionAmount = transactionAmount; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public LocalDate getTransactionDate() { return transactionDate; }
    public void setTransactionDate(LocalDate transactionDate) { this.transactionDate = transactionDate; }
}
