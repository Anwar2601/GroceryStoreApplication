package com.example.gsa.impl;

import com.example.gsa.enums.ItemTypeEnum;
import com.example.gsa.models.Bill;
import com.example.gsa.models.Item;
import com.example.gsa.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    @Test
    public void testCalculateDefaultDiscount(){
        List<Item> items = new ArrayList<>();
        Item item = new Item(101,"ItemName", ItemTypeEnum.GROCERY, 100, 2, 200);
        items.add(item);
        Bill bill = new Bill(UUID.randomUUID(), UUID.randomUUID(), 200.0, items);

        double discount = employeeServiceImpl.calculateDefaultDiscount(bill);
        Assert.isTrue(discount==10.0,"Test Failed");
    }

    @Test
    public void testFilterGroceryItem(){
        Item item = new Item(101,"ItemName", ItemTypeEnum.GROCERY, 100, 1, 200);
        boolean b = employeeServiceImpl.filterGroceryItem(item);
        Assert.isTrue(b==false,"Test Failed");
    }

    @Test
    public void testCalculateDiscount(){
        List<Item> items = new ArrayList<>();
        Item item = new Item(101,"ItemName", ItemTypeEnum.PERSONALCARE, 200, 1, 200);
        items.add(item);
        Bill bill = new Bill(UUID.randomUUID(), UUID.randomUUID(), 200.0, items);
        double discount = employeeServiceImpl.calculateDiscount(bill);
        Assert.isTrue(discount==70.0,"Test Failed");
    }
}
