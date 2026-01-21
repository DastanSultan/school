package com.example.School.dto.response;

import com.example.School.dto.common.ShortUserDto;

import java.util.ArrayList;
import java.util.List;

public class SubjectDto{
    private String name;
    private String teacherName;
    private List<ShortUserDto> students = new ArrayList<>();

    protected SubjectDto(){}
    public SubjectDto(String name,String teacherName, List<ShortUserDto> students){
        this.name = name;
        this.teacherName = teacherName;
        this.students = students;
    }

    //Getters

    public String getName( ){
        return name;
    }

    public String getTeacherName( ){
        return teacherName;
    }

    public List<ShortUserDto> getStudents( ){
        return students;
    }
}
