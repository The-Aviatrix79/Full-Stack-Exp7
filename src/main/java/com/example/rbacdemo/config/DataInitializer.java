package com.example.rbacdemo.config;

import com.example.rbacdemo.model.AppUser;
import com.example.rbacdemo.model.Role;
import com.example.rbacdemo.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner seedUsers(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.save(new AppUser("user", passwordEncoder.encode("user123"), Role.ROLE_USER));
                userRepository.save(new AppUser("admin", passwordEncoder.encode("admin123"), Role.ROLE_ADMIN));
            }
        };
    }
}
