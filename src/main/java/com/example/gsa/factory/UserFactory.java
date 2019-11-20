package com.example.gsa.factory;

import com.example.gsa.enums.UserTypeEnum;
import com.example.gsa.models.User;
import com.example.gsa.service.UserService;
import com.example.gsa.service.impl.AffiliateServiceImpl;
import com.example.gsa.service.impl.CustomerServiceImpl;
import com.example.gsa.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class UserFactory {

    @Autowired
    private AffiliateServiceImpl affiliateServiceImpl;

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    /**
     * Factory to get the User Service Impl for Discount Calculations
     *
     * @param user
     * @return
     */
    public UserService getUserService(Optional<User> user){
        UserService userService = null;
        if(checkUserIsAnEmployee(user))
            userService = employeeServiceImpl;
        else if(user.isPresent()&&user.get().getUserType().equals(UserTypeEnum.AFFILIATE))
            userService = affiliateServiceImpl;
        else if(checkUserJoiningDate(user))
            userService = customerServiceImpl;
        return userService;
    }

    /**
     * Check if User has been affialiated
     * to the store for 2 years or more.
     *
     * @param user
     * @return
     */
    private boolean checkUserJoiningDate(Optional<User> user) {
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
    private boolean checkUserIsAnEmployee(Optional<User> user) {
        return (user.isPresent()&&user.get().getUserType().equals(UserTypeEnum.EMPLOYEE));
    }
}
