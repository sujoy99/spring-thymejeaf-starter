package com.starter.demo.service.imp;

import com.starter.demo.dto.UserRegistrationDTO;
import com.starter.demo.model.Role;
import com.starter.demo.model.User;
import com.starter.demo.repository.UserRepository;
import com.starter.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDTO registrationDTO) {
        User user = new User(registrationDTO.getFirstName(), registrationDTO.getLastName(), registrationDTO.getEmail(),
                registrationDTO.getPassword(), Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
}
