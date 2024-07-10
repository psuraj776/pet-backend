package com.petvet.controller;

import com.petvet.model.User;
import com.petvet.service.UserService;
import com.petvet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public Map<String, Object> registerUser(@RequestBody User user) {
	logger.debug("Registering user with email: {}", user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "User registered successfully!");
	logger.info("User registered successfully: {}", user.getEmail());
        return response;
    }

    @PostMapping("/login")
    public Map<String, Object> authenticateUser(@RequestBody User user) {
	logger.debug("Authenticating user with email: {}", user.getEmail());
        Map<String, Object> response = new HashMap<>();
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            response.put("success", true);
            response.put("message", "User authenticated successfully!");
	    logger.info("User authenticated successfully: {}", user.getEmail());
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Invalid email or password");
	    logger.error("Authentication failed for user: {}", user.getEmail(), e);
        }
        return response;
    }

    @GetMapping("/status")
    public Map<String, String> status() {
	logger.debug("Checking backend status");
        Map<String, String> response = new HashMap<>();
        response.put("message", "Backend is running");
        return response;
    }
}

