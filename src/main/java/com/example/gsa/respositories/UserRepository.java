package com.example.gsa.respositories;

import com.example.gsa.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {
    /**
     * Map of Users to Simulate DataBase Table
     */
    private Map<UUID, User> users = new HashMap<>();

    /**
     * Get User From Database
     *
     * @param userId
     * @return
     */
    public Optional<User> getUser(UUID userId){
        return Optional.ofNullable(users.get(userId));
    }

    /**
     * Save User in Database
     *
     * @param user
     * @return
     */
    public User saveUser(User user){
        return users.put(user.getUserId(),user);
    }
}
