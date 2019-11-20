package com.example.gsa.service.impl;

import com.example.gsa.models.User;
import com.example.gsa.respositories.UserRepository;
import com.example.gsa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(UUID empId) {
        return userRepository.getUser(empId);
    }
}
