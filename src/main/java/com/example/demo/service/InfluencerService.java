package com.example.project.service;

import com.example.project.dto.InfluencerDTO;
import com.example.project.entity.Influencer;
import com.example.project.repository.InfluencerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InfluencerService {

    private final InfluencerRepository repository;

    public InfluencerService(InfluencerRepository repository) {
        this.repository = repository;
    }

    public Influencer createInfluencer(InfluencerDTO dto) {
        // Check duplicate socialHandle
        repository.findBySocialHandle(dto.getSocialHandle()).ifPresent(i -> {
            throw new RuntimeException("Social handle already exists");
        });

        Influencer influencer = new Influencer();
        influencer.setName(dto.getName());
        influencer.setSocialHandle(dto.getSocialHandle());
        influencer.setEmail(dto.getEmail());
        influencer.setActive(dto.getActive() != null ? dto.getActive() : true);

        return repository.save(influencer);
    }

    public List<Influencer> getAllInfluencers() {
        return repository.findAll();
    }

    public Influencer getInfluencerById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Influencer not found"));
    }

    public Influencer updateInfluencer(Long id, InfluencerDTO dto) {
        Influencer influencer = getInfluencerById(id);

        influencer.setName(dto.getName());
        influencer.setSocialHandle(dto.getSocialHandle());
        influencer.setEmail(dto.getEmail());
        influencer.setActive(dto.getActive() != null ? dto.getActive() : influencer.getActive());

        return repository.save(influencer);
    }

    public void deleteInfluencer(Long id) {
        Influencer influencer = getInfluencerById(id);
        repository.delete(influencer);
    }
}
