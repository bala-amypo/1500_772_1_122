package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private DiscountCode discountCode;

    private BigDecimal totalSales;
    private Integer totalTransactions;
    private Double roiPercentage;

    public RoiReport() {}

    public Long getId() { return id; }
    public DiscountCode getDiscountCode() { return discountCode; }
    public BigDecimal getTotalSales() { return totalSales; }
    public Integer getTotalTransactions() { return totalTransactions; }
    public Double getRoiPercentage() { return roiPercentage; }

    public void setId(Long id) { this.id = id; }
    public void setDiscountCode(DiscountCode discountCode) { this.discountCode = discountCode; }
    public void setTotalSales(BigDecimal totalSales) { this.totalSales = totalSales; }
    public void setTotalTransactions(Integer totalTransactions) { this.totalTransactions = totalTransactions; }
    public void setRoiPercentage(Double roiPercentage) { this.roiPercentage = roiPercentage; }
}
