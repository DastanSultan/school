package com.example.School.service;

import com.example.School.exception.consum.ResourseNotFoundException;
import com.example.School.model.User;
import com.example.School.repository.UserRepository;
import com.example.School.security.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByEmail(username).orElseThrow(() -> new ResourseNotFoundException("User not found"));
        return new CustomUserDetails(user);
    }
}
