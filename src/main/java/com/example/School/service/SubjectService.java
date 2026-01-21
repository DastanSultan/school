package com.example.School.service;

import com.example.School.dto.request.CreateSubject;
import com.example.School.dto.response.SubjectDto;
import com.example.School.exception.consum.ResourseNotFoundException;
import com.example.School.mapper.SubjecMapper;
import com.example.School.model.Subject;
import com.example.School.model.User;
import com.example.School.repository.SubjectRepository;
import com.example.School.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SubjectService{
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;

    public SubjectService(UserRepository userRepository, SubjectRepository subjectRepository){
        this.userRepository = userRepository;
        this.subjectRepository = subjectRepository;
    }
    @PreAuthorize("hasRole('ADMIN')")
    // Create subject + assign teacher
    public void createSubject(CreateSubject createSubject){
        User teacher = userRepository.findById(createSubject.getTeacherId()).orElseThrow(() -> new ResourseNotFoundException("Teacher not found"));
        Subject subject = new Subject(createSubject.getName());
        subject.setTeacher(teacher);
        subjectRepository.save(subject);
    }

    // Add subject to teacher
    @PreAuthorize("hasRole('ADMIN')")
    public void addSubjectToTeacher(Long subjectId, Long teacherId){
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new ResourseNotFoundException("Subject not found"));
        User user = userRepository.findById(teacherId).orElseThrow(() -> new ResourseNotFoundException("Teacher not found"));
        user.addSubjectToTeacher(subject);
    }

    // Add Student to subject
    @PreAuthorize("hasRole('ADMIN')")
    public void addStudentToSubject(Long studentId, Long subjectId){
        User student = userRepository.findById(studentId).orElseThrow(() -> new ResourseNotFoundException("Student not found"));
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new ResourseNotFoundException("Subject not found"));
        student.addSubjectToStudent(subject);
    }

    // Get all subjects
    public List<SubjectDto> getAllSubjects(){
        return subjectRepository.findAll().stream().map(SubjecMapper::subjectDto).toList();
    }

    // Get subject by name
    public SubjectDto getSubjectsByName(String subjectName){
        Subject subject = subjectRepository.findByName(subjectName).orElseThrow(() -> new ResourseNotFoundException("Subject not found"));
        return SubjecMapper.subjectDto(subject);
    }
}
