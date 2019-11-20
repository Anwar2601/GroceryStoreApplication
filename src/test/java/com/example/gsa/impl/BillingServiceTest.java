package com.example.gsa.impl;

import com.example.gsa.enums.ItemTypeEnum;
import com.example.gsa.models.Bill;
import com.example.gsa.models.Item;
import com.example.gsa.service.UserService;
import com.example.gsa.service.impl.BillingService;
import com.example.gsa.service.impl.DiscountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class BillingServiceTest {

    @Mock
    private UserService userServiceImpl;

    @Mock
    private DiscountService discountService;

    @InjectMocks
    private BillingService billingService;

    /**
     * Testing for One Grocery Item with User who is an Employee
     */
    @Test
    void testForOneGroceryItemWithUserAsEmployee(){
        Mockito.when(discountService.getDiscount(Mockito.any())).thenReturn(5.0);
        List<Item> items = new ArrayList<>();
        Item item = new Item(101,"ItemName", ItemTypeEnum.GROCERY, 100, 1, 100);
        items.add(item);
        Bill bill = new Bill(UUID.randomUUID(), UUID.randomUUID(), 100.0, items);
        double payableAmount = billingService.processBill(bill);
        Assert.isTrue(payableAmount==95.0,"Test Failed");
    }

    /**
     * Testing for One Grocery Item with User who is an Employee
     */
    @Test
    void testForOneMultipleItemWithUserAsEmployee(){
        Mockito.when(discountService.getDiscount(Mockito.any())).thenReturn(35.0);
        List<Item> items = new ArrayList<>();
        Item item = new Item(101,"ItemName1", ItemTypeEnum.GROCERY, 100, 1, 100);
        items.add(item);
        item = new Item(102,"ItemName2", ItemTypeEnum.PERSONALCARE, 100, 1, 100);
        items.add(item);
        Bill bill = new Bill(UUID.randomUUID(), UUID.randomUUID(), 200.0, items);
        double payableAmount = billingService.processBill(bill);
        Assert.isTrue(payableAmount==165.0,"Test Failed");
    }
}
