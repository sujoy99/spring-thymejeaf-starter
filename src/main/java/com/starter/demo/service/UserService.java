package com.starter.demo.service;

import com.starter.demo.dto.UserRegistrationDTO;
import com.starter.demo.model.User;

public interface UserService {

    User save(UserRegistrationDTO registrationDTO);
}
