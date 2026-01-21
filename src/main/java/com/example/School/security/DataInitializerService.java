package com.example.School.security;

import com.example.School.model.Role;
import com.example.School.model.User;
import com.example.School.repository.RoleRepository;
import com.example.School.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DataInitializerService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void init() {
        createRoles();
        createAdmin();
    }

    private void createRoles() {
        List<String> roles = List.of("ROLE_STUDENT", "ROLE_TEACHER", "ROLE_ADMIN");
        for (String role : roles) {
            roleRepository.findByName(role)
                    .orElseGet(() -> roleRepository.save(new Role(role)));
        }
    }

    private void createAdmin() {
        String email = "dastandaku01@gmail.com";

        if (userRepository.existsByEmail(email)) return;

        Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                .orElseThrow();

        com.example.School.model.User admin = new User(
                "Dastan",
                email,
                passwordEncoder.encode("12345!"),
                24
        );

        admin.addRole(adminRole);
        userRepository.save(admin);
    }
}