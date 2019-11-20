package com.example.gsa.service.impl;

import com.example.gsa.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    /**
     * discount Service to get discount amount.
     */
    @Autowired
    private DiscountService discountService;

    /**
     * processBill to get discount from Discount Service
     * and calculate amount payable
     *
     * @param bill
     * @return
     */
    public double processBill(Bill bill){
        double discount = discountService.getDiscount(bill);
        double amountPayable = bill.getAmount() - discount;
        return amountPayable;
    }
}
