package com.example.School.service;
import com.example.School.dto.response.UserDto;
import com.example.School.exception.consum.ResourseNotFoundException;
import com.example.School.mapper.UserMapper;
import com.example.School.model.User;
import com.example.School.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    // get user by id
    @PreAuthorize ("hasRole('ADMIN')")
    public UserDto getById (Long userId){
        User user= userRepository.findById(userId).orElseThrow(() -> new ResourseNotFoundException("User not found"));
        return UserMapper.userDto(user);
    }

}
