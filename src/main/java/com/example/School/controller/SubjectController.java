package com.example.School.controller;

import com.example.School.dto.request.CreateSubject;
import com.example.School.dto.response.SubjectDto;
import com.example.School.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/subject")

public class SubjectController{
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    // Create subject + assign teacher
    @PostMapping
    public void createSubject(@Valid @RequestBody CreateSubject createSubject){
        subjectService.createSubject(createSubject);

    }

    // Add subject to teacher
    @PostMapping("/{subjectId}/teacher/{teacherId}")
    public void addSubjectToTeacher(@PathVariable Long subjectId, @PathVariable Long teacherId){
        subjectService.addSubjectToTeacher(subjectId, teacherId);
    }

    // Add Student to subject
    @PostMapping("/{subjectId}/user/{studentId}")
    public void addStudentToSubject(Long studentId, Long subjectId){
        subjectService.addStudentToSubject(studentId, subjectId);
    }

    // Get all subjects
    @GetMapping
    public List<SubjectDto> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    // Get subject by name
    public SubjectDto getSubjectsByName(@RequestBody String subjectName){
        return subjectService.getSubjectsByName(subjectName);
    }
}
