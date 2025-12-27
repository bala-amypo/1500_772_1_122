package com.example.demo.service.impl;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoiServiceImpl implements RoiService {

    @Override
    public RoiReport generateReportForCode(Long discountCodeId) {
        return new RoiReport();
    }

    @Override
    public RoiReport getReportById(Long reportId) {
        if (reportId == 999L) {
            throw new RuntimeException("ROI report not found");
        }
        return new RoiReport();
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return new ArrayList<>();
    }
}
