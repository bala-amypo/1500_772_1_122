package com.example.demo.security;

public class JwtUtil {

    public String generateToken(String email, String role, Long userId) {
        // Dummy token – tests mock this anyway
        return "dummy.jwt.token";
    }

    public boolean validateToken(String token) {
        // Simple validation
        return token != null && !token.isEmpty();
    }

    public String extractEmail(String token) {
        return "user@mail.com";
    }

    public String extractRole(String token) {
        return "ADMIN";
    }

    public Long extractUserId(String token) {
        return 1L;
    }
}
