package com.example.School.service;

import com.example.School.dto.request.CreateUserDto;
import com.example.School.dto.request.auth.LoginRequest;
import com.example.School.dto.request.auth.RegisterRequest;
import com.example.School.exception.consum.ResourseNotFoundException;
import com.example.School.model.Role;
import com.example.School.model.User;
import com.example.School.repository.RoleRepository;
import com.example.School.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtService jwtService){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    // register
    public void register(RegisterRequest request){
        if (userRepository.existsByEmail(request.getEmail())){
            throw new ResourseNotFoundException("Email is exists");
        }
        User user = new User(request.getName(), request.getEmail(), passwordEncoder.encode(request.getPassword()) , request.getAge());
        Role role = roleRepository.findByName("ROLE_STUDENT").orElseThrow(() -> new ResourseNotFoundException("Role Student not found"));
        user.addRole(role);
        userRepository.save(user);
    }

    // login
    public String login(LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new ResourseNotFoundException("Email not found"));
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new ResourseNotFoundException("Password is wrong");
        }
        return jwtService.generateToken(user.getEmail());
    }
}
