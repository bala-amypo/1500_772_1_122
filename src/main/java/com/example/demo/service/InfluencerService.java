package com.example.demo.service;

import com.example.demo.dto.InfluencerRequest;
import com.example.demo.model.Influencer;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfluencerService {

    private final InfluencerRepository influencerRepository;

    public InfluencerService(InfluencerRepository influencerRepository) {
        this.influencerRepository = influencerRepository;
    }

    public Influencer createInfluencer(InfluencerRequest request) {
        Influencer influencer = new Influencer(
            request.getName(),
            request.getEmail(),
            request.getPlatform(),
            request.getFollowers()
        );
        return influencerRepository.save(influencer);
    }

    public List<Influencer> getAllInfluencers() {
        return influencerRepository.findAll();
    }

    public Influencer getInfluencerById(Long id) {
        return influencerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Influencer not found with id " + id));
    }

    public Influencer updateInfluencer(Long id, InfluencerRequest request) {
        Influencer influencer = influencerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Influencer not found with id " + id));

        influencer.setName(request.getName());
        influencer.setEmail(request.getEmail());
        influencer.setPlatform(request.getPlatform());
        influencer.setFollowers(request.getFollowers());

        return influencerRepository.save(influencer);
    }

    public void deleteInfluencer(Long id) {
        Influencer influencer = influencerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Influencer not found with id " + id));
        influencerRepository.delete(influencer);
    }
}
