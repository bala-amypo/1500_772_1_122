package com.example.project.controller;

import com.example.project.dto.InfluencerDTO;
import com.example.project.entity.Influencer;
import com.example.project.service.InfluencerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/influencers")
public class InfluencerController {

    private final InfluencerService service;

    public InfluencerController(InfluencerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Influencer> createInfluencer(@Valid @RequestBody InfluencerDTO dto) {
        return new ResponseEntity<>(service.createInfluencer(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Influencer> getAllInfluencers() {
        return service.getAllInfluencers();
    }

    @GetMapping("/{id}")
    public Influencer getInfluencer(@PathVariable Long id) {
        return service.getInfluencerById(id);
    }

    @PutMapping("/{id}")
    public Influencer updateInfluencer(@PathVariable Long id, @Valid @RequestBody InfluencerDTO dto) {
        return service.updateInfluencer(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInfluencer(@PathVariable Long id) {
        service.deleteInfluencer(id);
        return ResponseEntity.noContent().build();
    }
}
