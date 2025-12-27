package com.example.demo.service;

import com.example.demo.model.RoiReport;
import java.util.List;

public interface RoiReportService {
    RoiReport createRoiReport(RoiReport roiReport);
    List<RoiReport> getAllRoiReports();
    RoiReport getRoiReportById(Long id);
}
