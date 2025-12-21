package com.example.demo.controller;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roireports")
public class RoiReportController {

    private final RoiReportService roiReportService;

    public RoiReportController(RoiReportService roiReportService) {
        this.roiReportService = roiReportService;
    }

    @PostMapping
    public ResponseEntity<RoiReport> createReport(@RequestBody RoiReport report) {
        RoiReport savedReport = roiReportService.save(report);
        return ResponseEntity.ok(savedReport);
    }

    @GetMapping
    public ResponseEntity<List<RoiReport>> getAllReports() {
        return ResponseEntity.ok(roiReportService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoiReport> getReportById(@PathVariable Long id) {
        return roiReportService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        roiReportService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
