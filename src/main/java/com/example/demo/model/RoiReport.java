package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class RoiReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reportName;
    private Double roiValue;
    private LocalDate generatedDate;


    public RoiReport() {}
    public RoiReport(String reportName, Double roiValue, LocalDate generatedDate) {
        this.reportName = reportName;
        this.roiValue = roiValue;
        this.generatedDate = generatedDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReportName() { return reportName; }
    public void setReportName(String reportName) { this.reportName = reportName; }
    public Double getRoiValue() { return roiValue; }
    public void setRoiValue(Double roiValue) { this.roiValue = roiValue; }
    public LocalDate getGeneratedDate() { return generatedDate; }
    public void setGeneratedDate(LocalDate generatedDate) { this.generatedDate = generatedDate; }
}
