package com.example.gsa.service.impl;

import com.example.gsa.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    @Autowired
    private DiscountService discountService;

    public double processBill(Bill bill){
        double discount = discountService.getDiscount(bill);
        return bill.getAmount()-discount;
    }
}
