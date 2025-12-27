package com.example.demo.repository;

import com.example.demo.model.ROIReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ROIReportRepository extends JpaRepository<ROIReport, Long> {
    // No extra methods needed for testcases
}
