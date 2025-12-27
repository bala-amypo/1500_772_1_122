package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String socialHandle;
    private boolean active = true;

    @OneToMany(mappedBy = "influencer")
    private List<DiscountCode> discountCodes;

    public Influencer() {}

    public Influencer(String name, String socialHandle, boolean active) {
        this.name = name;
        this.socialHandle = socialHandle;
        this.active = active;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSocialHandle() { return socialHandle; }
    public boolean isActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSocialHandle(String socialHandle) { this.socialHandle = socialHandle; }
    public void setActive(boolean active) { this.active = active; }
}
