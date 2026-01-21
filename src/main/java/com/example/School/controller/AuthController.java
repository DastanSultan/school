package com.example.School.controller;

import com.example.School.dto.request.auth.LoginRequest;
import com.example.School.dto.request.auth.RegisterRequest;
import com.example.School.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController{
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegisterRequest request){
        authService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginRequest loginRequest){
        String token = authService.login(loginRequest);
        Map<String, String> response = Map.of(
                "token", token,
                "type", "Bearer"
        );
        return ResponseEntity.ok(response);
    }
}
