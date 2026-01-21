package com.example.School.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private User teacher;

    @ManyToMany(mappedBy = "subjectsStudent")
    private List<User> students = new ArrayList<>();

    protected Subject(){}
    public Subject(String name){
        this.name = name;
    }

    // Business logic
    public void setTeacher(User teacher){
        this.teacher = teacher;
    }
    public void addStudentToSubject(User student){
        if (!students.contains(student)){
            students.add(student);
            if (student.getSubjectsStudent().contains(this)){
                student.addSubjectToStudent(this);
            }
        }
    }

    //Getters
    public Long getId( ){
        return id;
    }

    public String getName( ){
        return name;
    }

    public User getTeacher( ){
        return teacher;
    }

    public List<User> getStudents( ){
        return students;
    }
}
