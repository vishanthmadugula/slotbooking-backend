package com.example.sportsbooking.controller;

import com.example.sportsbooking.model.User;
import com.example.sportsbooking.repository.UserRepository;
import com.example.sportsbooking.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        user.setRole("USER");
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        System.out.println("Login attempt for email: " + user.getEmail());

        User dbUser = userRepository.findAll()
            .stream()
            .filter(u -> u.getEmail().equals(user.getEmail()) &&
                         u.getPassword().equals(user.getPassword()))
            .findFirst()
            .orElse(null);

        if (dbUser == null) {
            System.out.println("Login failed: Invalid credentials for " + user.getEmail());
            throw new RuntimeException("Invalid credentials");
        }

        System.out.println("Login successful for " + user.getEmail());
        return JwtUtil.generateToken(dbUser.getEmail());
    }
}