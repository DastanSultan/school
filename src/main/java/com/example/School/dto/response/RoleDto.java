package com.example.School.dto.response;

public class RoleDto{
    private final String name;

    public RoleDto(String name){
        this.name = name;
    }

    public String getName( ){
        return name;
    }
}
