package com.example.demo.service;

import com.example.demo.model.ROIReport;
import java.util.List;

public interface ROIReportService {
    List<ROIReport> getAllReports();
    ROIReport getReportById(Long id);
    ROIReport updateReport(Long id, ROIReport report);
}
