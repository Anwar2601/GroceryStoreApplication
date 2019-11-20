package com.example.gsa.service.impl;

import com.example.gsa.constants.Constants;
import com.example.gsa.enums.ItemTypeEnum;
import com.example.gsa.models.Bill;
import com.example.gsa.models.Item;
import com.example.gsa.models.User;
import com.example.gsa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiscountService {

    @Autowired
    private UserService userService;

    public double getDiscount(Bill bill) {
        Optional<User> user = userService.getUser(bill.getUserId());
        double discount=0.0;
        if(userService.checkUserType(user))
            discount= Constants.DISCOUNT_THIRTY;
        else if(user.isPresent())
            discount= Constants.DISCOUNT_TEN;
        else if(userService.checkUserJoiningDate(user))
            discount= Constants.DISCOUNT_FIVE;
        return calculateDiscount(bill,discount)+calculateDiscount(bill);
    }

    private double calculateDiscount(Bill bill, double discountRate) {
        return bill.getItems().stream()
                .filter(this::filterGroceryItem)
                .map(item -> item.getAmount() * discountRate)
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    private double calculateDiscount(Bill bill) {
        double amount = bill.getAmount();
        return (amount/100)*5;
    }

    private boolean filterGroceryItem(Item item) {
        return !ItemTypeEnum.GROCERY.equals(item.getItemType());
    }
}
