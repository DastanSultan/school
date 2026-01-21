package com.example.School.mapper;

import com.example.School.dto.common.ShortUserDto;
import com.example.School.dto.response.SubjectDto;
import com.example.School.model.Subject;

import java.util.List;

public class SubjecMapper{
    public static SubjectDto subjectDto(Subject subject){
        List<ShortUserDto> students = subject.getStudents().stream().map(
                e -> new ShortUserDto(e.getName(), e.getEmail(), e.getAge())
        ).toList();
        return new SubjectDto(subject.getName(), subject.getTeacher().getName(), students);
    }
}
