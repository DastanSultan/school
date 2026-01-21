package com.example.School.security;

import com.example.School.security.DataInitializerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

@Configuration
public class DataInitializerConfig {

    @Bean
    CommandLineRunner init(DataInitializerService service) {
        return args -> service.init();
    }
}