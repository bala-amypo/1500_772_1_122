package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sale_transactions")
public class SaleTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "discount_code_id", nullable = false)
    private DiscountCode discountCode;

    @Column(nullable = false)
    private BigDecimal transactionAmount;

    private LocalDateTime transactionDate;

    private Long customerId;

    // ✅ No-arg constructor
    public SaleTransaction() {}

    // ✅ Parameterized constructor
    public SaleTransaction(
            DiscountCode discountCode,
            BigDecimal transactionAmount,
            LocalDateTime transactionDate,
            Long customerId
    ) {
        this.discountCode = discountCode;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.customerId = customerId;
    }

    // getters & setters
}
