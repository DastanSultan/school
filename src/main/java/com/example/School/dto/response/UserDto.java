package com.example.School.dto.response;

import com.example.School.dto.common.ShortSubjectDto;
import com.example.School.model.Role;

import java.util.ArrayList;
import java.util.List;

public class UserDto{
    private String name;
    private String email;
    private int age;
    private List<RoleDto> role;

    private List<ShortSubjectDto> subjects = new ArrayList<>();
    protected UserDto(){}
    public UserDto(String name, String email, int age,List<RoleDto> role, List<ShortSubjectDto> subjects){
        this.name = name;
        this.email = email;
        this.age = age;
        this.subjects = subjects;
        this.role = role;
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

    public List<RoleDto> getRole( ){
        return role;
    }

    public List<ShortSubjectDto> getSubjects( ){
        return subjects;
    }
}
