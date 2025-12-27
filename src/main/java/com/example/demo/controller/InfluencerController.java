package com.example.demo.controller;

import com.example.demo.dto.InfluencerRequest;
import com.example.demo.model.Influencer;
import com.example.demo.service.InfluencerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Influencers", description = "Operations related to influencers")
@RestController
@RequestMapping("/api/influencers")
public class InfluencerController {

    private final InfluencerService influencerService;

    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

    @Operation(summary = "Create a new influencer")
    @PostMapping
    public ResponseEntity<Influencer> create(@RequestBody InfluencerRequest request) {
        return ResponseEntity.ok(influencerService.createInfluencer(request));
    }

    @Operation(summary = "Get all influencers")
    @GetMapping
    public ResponseEntity<List<Influencer>> getAll() {
        return ResponseEntity.ok(influencerService.getAllInfluencers());
    }

    @Operation(summary = "Get influencer by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Influencer> getById(@PathVariable Long id) {
        return ResponseEntity.ok(influencerService.getInfluencerById(id));
    }

    @Operation(summary = "Update influencer by ID")
    @PutMapping("/{id}")
    public ResponseEntity<Influencer> update(@PathVariable Long id, @RequestBody InfluencerRequest request) {
        return ResponseEntity.ok(influencerService.updateInfluencer(id, request));
    }

    @Operation(summary = "Delete influencer by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        influencerService.deleteInfluencer(id);
        return ResponseEntity.ok().build();
    }
}
