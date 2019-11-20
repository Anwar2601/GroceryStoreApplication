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

    /**
     * User Repository to interact with
     * Database for User CRUD.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Get User from DB for given userId.
     *
     * @param empId
     * @return
     */
    public Optional<User> getUser(UUID empId) {
        return userRepository.getUser(empId);
    }

    /**
     * Save given User Object in DB.
     *
     * @param user
     * @return
     */
    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }
}
