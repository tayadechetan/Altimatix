package com.ac.altimatix.Altimatix.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ac.altimatix.Altimatix.controller.dto.UserRegistrationDto;
import com.ac.altimatix.Altimatix.model.User;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);

    void updatePassword(String password, Long userId);
}
