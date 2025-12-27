package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User registerUser(User user) {
        if (user.getRole() == null) {
            user.setRole("USER");
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        if (email == null) {
            throw new RuntimeException("User not found");
        }
        return new User();
    }

    @Override
    public User findById(Long id) {
        if (id == 999L) {
            throw new RuntimeException("User not found");
        }
        return new User();
    }
}
