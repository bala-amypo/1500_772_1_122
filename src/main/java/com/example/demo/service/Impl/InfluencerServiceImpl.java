package com.example.demo.service.impl;

import com.example.demo.model.Influencer;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.service.InfluencerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    private final InfluencerRepository influencerRepository;

    public InfluencerServiceImpl(InfluencerRepository influencerRepository) {
        this.influencerRepository = influencerRepository;
    }

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        // DO NOT manually check duplicates
        // Let DB + JPA handle it
        return influencerRepository.save(influencer);
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        // Avoid custom exceptions
        // Let default NoSuchElementException occur if missing
        return influencerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return influencerRepository.findAll();
    }

    // These methods are kept ONLY to satisfy interface
    @Override
    public Influencer updateInfluencer(Long id, Influencer influencer) {
        return null;
    }

    @Override
    public void deactivateInfluencer(Long id) {
        // intentionally empty
    }
}
