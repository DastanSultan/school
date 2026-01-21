package com.example.School.dto.request.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class RegisterRequest{
    @NotBlank(message = "Name can't be empty") private String name;
    @NotBlank(message = "Name can't be empty") private String email;
    @NotBlank(message = "Name can't be empty")  private String password;
    @Positive (message = "Name can't be negative") private int age;

    protected RegisterRequest(){}
    public RegisterRequest(String name, String email, String password, int age){
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    // Getters

    public String getName( ){
        return name;
    }

    public String getEmail( ){
        return email;
    }

    public String getPassword( ){
        return password;
    }

    public int getAge( ){
        return age;
    }
}
