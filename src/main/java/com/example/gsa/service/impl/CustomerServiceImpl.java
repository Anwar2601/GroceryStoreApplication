package com.example.gsa.service.impl;

import com.example.gsa.constants.Constants;
import com.example.gsa.models.Bill;
import com.example.gsa.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements UserService {

    /**
     * Calculate Discounted Amount for
     * Percentage Based Criteria.
     *
     * @param bill
     * @return
     */
    public double calculateDiscount(Bill bill) {
        return calculateDefaultDiscount(bill)+bill.getItems().stream()
                .filter(this::filterGroceryItem)
                .map(item -> item.getAmount() * Constants.DISCOUNT_FIVE)
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
