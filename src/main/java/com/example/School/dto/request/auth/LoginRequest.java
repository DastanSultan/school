package com.example.School.dto.request.auth;


import jakarta.validation.constraints.NotBlank;

public class LoginRequest{
    @NotBlank(message = "Name can't be empty") private String email;
    @NotBlank(message = "Name can't be empty")  private String password;

    protected LoginRequest(){}
    public LoginRequest(String email, String password){
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getEmail( ){
        return email;
    }

    public String getPassword( ){
        return password;
    }
}
