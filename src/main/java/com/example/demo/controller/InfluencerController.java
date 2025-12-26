package com.example.demo.controller;

import com.example.demo.dto.InfluencerRequest;
import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/influencers")
public class InfluencerController {

    private final InfluencerService influencerService;

    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

    @PostMapping
    public ResponseEntity<Influencer> create(@RequestBody InfluencerRequest request) {
        return ResponseEntity.ok(influencerService.createInfluencer(request));
    }

    @GetMapping
    public ResponseEntity<List<Influencer>> getAll() {
        return ResponseEntity.ok(influencerService.getAllInfluencers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Influencer> getById(@PathVariable Long id) {
        return ResponseEntity.ok(influencerService.getInfluencerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Influencer> update(@PathVariable Long id, @RequestBody InfluencerRequest request) {
        return ResponseEntity.ok(influencerService.updateInfluencer(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        influencerService.deleteInfluencer(id);
        return ResponseEntity.ok().build();
    }
}
