package com.example.School.controller;

import com.example.School.dto.response.UserDto;
import com.example.School.mapper.UserMapper;
import com.example.School.model.User;
import com.example.School.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController{
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDto getUsers(@PathVariable Long id){
        return userService.getById(id);
    }
}
