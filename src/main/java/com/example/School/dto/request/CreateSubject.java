package com.example.School.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

public class CreateSubject{
    @NotBlank (message = "Name can't be empty") private String name;
    @NotNull (message = "Teacher id can't be negative") private Long teacherId;

    protected CreateSubject(){}
    public CreateSubject(String name, Long teacherId){
        this.name = name;
        this.teacherId = teacherId;
    }

    //Getters
    public String getName( ){
        return name;
    }

    public Long getTeacherId( ){
        return teacherId;
    }
}
