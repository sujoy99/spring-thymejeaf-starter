package com.starter.demo.service;

import com.starter.demo.dto.UserRegistrationDTO;
import com.starter.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDTO registrationDTO);
}
