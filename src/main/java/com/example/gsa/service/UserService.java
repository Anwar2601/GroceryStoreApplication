package com.example.gsa.service;

import com.example.gsa.enums.UserTypeEnum;
import com.example.gsa.models.User;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    /**
     * Abstract Method for Get User from DB
     *
     * @param empId
     * @return
     */
    Optional<User> getUser(UUID empId);

    /**
     * Abstract Method for Save User in DB
     *
     * @param user
     * @return
     */
    User saveUser(User user);

    /**
     * Check if User has been affialiated
     * to the store for 2 years or more.
     *
     * @param user
     * @return
     */
    default boolean checkUserJoiningDate(Optional<User> user) {
        if(user.isPresent())
        {
            LocalDate joiningDate = user.get().getJoiningDate();
            return joiningDate.plusYears(2).isBefore(LocalDate.now()) || joiningDate.plusYears(2).isEqual(LocalDate.now());
        }
        return Boolean.FALSE;
    }

    /**
     * Check if User is Employee or Customer
     *
     * @param user
     * @return
     */
    default boolean checkUserType(Optional<User> user) {
        return (user.isPresent()&&user.get().getUserType().equals(UserTypeEnum.EMPLOYEE));
    }
}
