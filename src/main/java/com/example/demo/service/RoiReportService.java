package com.example.demo.service;

import com.example.demo.model.RoiReport;
import com.example.demo.repository.RoiReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoiReportService {

    private final RoiReportRepository roiReportRepository;

    public RoiReportService(RoiReportRepository roiReportRepository) {
        this.roiReportRepository = roiReportRepository;
    }

    public RoiReport save(RoiReport report) {
        return roiReportRepository.save(report);
    }

    public List<RoiReport> getAll() {
        return roiReportRepository.findAll();
    }

    public Optional<RoiReport> getById(Long id) {
        return roiReportRepository.findById(id);
    }

    public void deleteById(Long id) {
        roiReportRepository.deleteById(id);
    }
}
