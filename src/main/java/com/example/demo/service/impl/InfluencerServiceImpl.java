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
        Influencer existing =
                influencerRepository.findBySocialHandle(influencer.getSocialHandle());

        if (existing != null) {
            throw new RuntimeException("Influencer already exists");
        }
        return influencerRepository.save(influencer);
    }

    @Override
    public Influencer updateInfluencer(Long id, Influencer influencer) {
        Influencer existing = influencerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Influencer not found"));

        existing.setName(influencer.getName());
        existing.setEmail(influencer.getEmail());
        existing.setSocialHandle(influencer.getSocialHandle());

        return influencerRepository.save(existing);
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        return influencerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Influencer not found"));
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return influencerRepository.findAll();
    }

    @Override
    public void deactivateInfluencer(Long id) {
        Influencer influencer = influencerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Influencer not found"));

        influencer.setActive(false);
        influencerRepository.save(influencer);
    }
}
