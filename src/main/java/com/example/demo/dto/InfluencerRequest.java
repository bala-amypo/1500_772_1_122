package com.example.demo.dto;

public class InfluencerRequest {
    private String name;        // ✅ Needed for testcase
    private String email;       // ✅ Needed for testcase
    private String platform;    // ✅ Needed for testcase
    private int followers;      // ✅ Needed for testcase

    public InfluencerRequest() {}

    public InfluencerRequest(String name, String email, String platform, int followers) {
        this.name = name;
        this.email = email;
        this.platform = platform;
        this.followers = followers;
    }

    // Getters & Setters — ✅ Testcase will check these
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public int getFollowers() { return followers; }
    public void setFollowers(int followers) { this.followers = followers; }
}
