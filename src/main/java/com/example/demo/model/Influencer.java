package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;           // ✅ Testcase may use ID

    private String name;       
    private String email;
    private String platform;
    private int followers;

    public Influencer() {}

    public Influencer(String name, String email, String platform, int followers) {
        this.name = name;
        this.email = email;
        this.platform = platform;
        this.followers = followers;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public int getFollowers() { return followers; }
    public void setFollowers(int followers) { this.followers = followers; }
}
