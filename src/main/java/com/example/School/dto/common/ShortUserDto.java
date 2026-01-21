package com.example.School.dto.common;

public class ShortUserDto{
   private String name;
    private String email;
    private int age;

    protected ShortUserDto(){}
    public ShortUserDto(String name, String email, int age){
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Getters

    public String getName( ){
        return name;
    }

    public String getEmail( ){
        return email;
    }

    public int getAge( ){
        return age;
    }
}
