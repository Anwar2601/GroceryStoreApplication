package com.example.gsa.service.impl;

import com.example.gsa.factory.UserFactory;
import com.example.gsa.models.Bill;
import com.example.gsa.models.User;
import com.example.gsa.respositories.UserRepository;
import com.example.gsa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillingService {

    /**
     * discount Service to get discount amount.
     */
    @Autowired
    private UserFactory userFactory;

    /**
     * User Repository to get User From DB
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * processBill to get discount from Discount Service
     * and calculate amount payable
     *
     * @param bill
     * @return
     */
    public double processBill(Bill bill){
        Optional<User> user = userRepository.getUser(bill.getUserId());
        UserService userService = userFactory.getUserService(user);
        double discount = userService.calculateDiscount(bill);
        double amountPayable = bill.getAmount() - discount;
        return amountPayable;
    }
}
