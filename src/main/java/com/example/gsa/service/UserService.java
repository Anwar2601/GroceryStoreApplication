package com.example.gsa.service;

import com.example.gsa.enums.ItemTypeEnum;
import com.example.gsa.models.Bill;
import com.example.gsa.models.Item;

public interface UserService {

    /**
     * Calculate Discount Amount
     * for Value Based Criteria.
     *
     * @param bill
     * @return
     */
    default double calculateDefaultDiscount(Bill bill) {
        double amount = bill.getAmount();
        return (amount/100)*5;
    }

    /**
     * Filter out Grocery Items.
     * Used to seperate Percentage Based Criteria
     * from others.
     *
     * @param item
     * @return
     */
    default boolean filterGroceryItem(Item item) {
        return !ItemTypeEnum.GROCERY.equals(item.getItemType());
    }

    /**
     * Calculate Scenario Based Discount
     *
     * @param bill
     * @return
     */
    double calculateDiscount(Bill bill);

}
