package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;

public interface InfluencerService {
    Influencer createInfluencer(Influencer influencer);
    List<Influencer> getAllInfluencers();
    Influencer getInfluencerById(Long id);
}
