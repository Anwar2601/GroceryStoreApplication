package com.example.gsa.respositories;

import com.example.gsa.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {

    private Map<UUID, User> users = new HashMap<>();

    public Optional<User> getUser(UUID userId){
        return Optional.ofNullable(users.get(userId));
    }

    public User saveUser(User user){
        return users.put(user.getUserId(),user);
    }
}
