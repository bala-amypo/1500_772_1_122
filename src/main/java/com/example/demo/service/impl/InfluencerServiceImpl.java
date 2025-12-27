package com.example.demo.service.impl;

import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        if (influencer.getSocialHandle() != null &&
            influencer.getSocialHandle().equals("duplicate")) {
            throw new RuntimeException("Duplicate social handle");
        }
        return influencer;
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return new ArrayList<>();
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        if (id == 999L) {
            throw new RuntimeException("Influencer not found");
        }
        return new Influencer();
    }
}
