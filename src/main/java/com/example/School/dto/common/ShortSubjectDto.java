package com.example.School.dto.common;

public class ShortSubjectDto{
    private String name;
    private String teacherName;

    protected ShortSubjectDto(){}
    public ShortSubjectDto(String name, String teacherName ){
        this.name = name;
        this.teacherName = teacherName;
    }

    // Getters

    public String getName( ){
        return name;
    }

    public String getTeacherName( ){
        return teacherName;
    }
}
