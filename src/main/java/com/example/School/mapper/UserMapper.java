package com.example.School.mapper;

import com.example.School.dto.common.ShortSubjectDto;
import com.example.School.dto.response.RoleDto;
import com.example.School.dto.response.UserDto;
import com.example.School.model.Role;
import com.example.School.model.User;

import java.util.List;

public class UserMapper{
    public static UserDto userDto(User user){
        List<ShortSubjectDto> subjects = user.getSubjectsStudent().stream().map(
                subject -> new ShortSubjectDto(subject.getName(), subject.getTeacher().getName())
        ).toList();
        List<RoleDto> roles = user.getRoles().stream().map(
                e -> new RoleDto(e.getName())
        ).toList();
        return new UserDto(user.getName(), user.getEmail(), user.getAge(),roles, subjects);
    }
}
