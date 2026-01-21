package com.example.School.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "users")
public class User{
    @Id @GeneratedValue private Long id;
    @Column(nullable = false) private String name;
    @Column(nullable = false, unique = true) private String email;
    @Column(nullable = false) private String password;
    @Column(nullable = false) private int age;

    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "student_subject",
    joinColumns = @JoinColumn(name = "studentId"),
    inverseJoinColumns = @JoinColumn(name = "subjectId"))
    private List<Subject> subjectsStudent = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "userId"),
    inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roles = new ArrayList<>();

    protected User(){}
    public User(String name, String email, String password, int age){
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    // Business logic
    public void addSubjectToTeacher(Subject subject){
        if (!subjects.contains(subject)){
            subjects.add(subject);
            if (subject.getTeacher() != this){
                subject.setTeacher(this);
            }
        }
    }

    // add subject to student
    public void addSubjectToStudent(Subject subject){
        if (!subjectsStudent.contains(subject)){
            subjectsStudent.add(subject);
            if (!subject.getStudents().contains(this)){
                subject.addStudentToSubject(this);
            }
        }
    }

    // add role
    public void addRole(Role role){
        if (!roles.contains(role)) {
            roles.add(role);
            if (!role.getUsers().contains(this)){
                role.addUser(this);
            }
        }
    }

    // Getters
    public Long getId( ){
        return id;
    }

    public String getName( ){
        return name;
    }

    public String getEmail( ){
        return email;
    }

    public String getPassword( ){
        return password;
    }

    public int getAge( ){
        return age;
    }

    public List<Role> getRoles( ){
        return roles;
    }

    public List<Subject> getSubjects( ){
        return subjects;
    }

    public List<Subject> getSubjectsStudent( ){
        return subjectsStudent;
    }
}
