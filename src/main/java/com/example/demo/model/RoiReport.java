package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalSales;
    private Integer totalTransactions;
    private Double roiPercentage;

    @ManyToOne
    private DiscountCode discountCode;

    public RoiReport() {}

    public Long getId() { return id; }
    public BigDecimal getTotalSales() { return totalSales; }
    public Integer getTotalTransactions() { return totalTransactions; }
    public Double getRoiPercentage() { return roiPercentage; }
    public DiscountCode getDiscountCode() { return discountCode; }

    public void setId(Long id) { this.id = id; }
    public void setTotalSales(BigDecimal totalSales) { this.totalSales = totalSales; }
    public void setTotalTransactions(Integer totalTransactions) { this.totalTransactions = totalTransactions; }
    public void setRoiPercentage(Double roiPercentage) { this.roiPercentage = roiPercentage; }
    public void setDiscountCode(DiscountCode discountCode) { this.discountCode = discountCode; }
}
