package com.example.School.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CreateUserDto{
    @NotBlank(message = "Name can't be empty") private String name;
    @NotBlank(message = "Email can't be empty") private String email;
    @NotBlank(message = "Password can't be empty") private String password;
    @Positive (message = "Age can't be negative") private int age;


    protected CreateUserDto(){}
    public CreateUserDto(String name, String email, String password, int age){
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
