package com.example.demo.service;

import com.example.demo.model.ROIReport;
import com.example.demo.repository.ROIReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ROIReportServiceImpl implements ROIReportService {

    @Autowired
    private ROIReportRepository roiReportRepository;

    @Override
    public List<ROIReport> getAllReports() {
        return roiReportRepository.findAll();
    }

    @Override
    public ROIReport getReportById(Long id) {
        return roiReportRepository.findById(id).orElse(null);
    }

    @Override
    public ROIReport updateReport(Long id, ROIReport report) {
        ROIReport existing = roiReportRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCampaignId(report.getCampaignId());
            existing.setTotalInvestment(report.getTotalInvestment());
            existing.setTotalReturn(report.getTotalReturn());
            existing.setRoiPercentage(report.getRoiPercentage());
            return roiReportRepository.save(existing);
        }
        return null;
    }
}
