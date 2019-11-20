package com.example.gsa.service;

import com.example.gsa.enums.UserTypeEnum;
import com.example.gsa.models.User;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    Optional<User> getUser(UUID empId);

    User saveUser(User user);

    default boolean checkUserJoiningDate(Optional<User> user) {
        if(user.isPresent())
        {
            LocalDate joiningDate = user.get().getJoiningDate();
            return joiningDate.plusYears(2).isBefore(LocalDate.now()) || joiningDate.plusYears(2).isEqual(LocalDate.now());
        }
        return Boolean.FALSE;
    }

    default boolean checkUserType(Optional<User> user) {
        return (user.isPresent()&&user.get().getUserType().equals(UserTypeEnum.EMPLOYEE));
    }
}
