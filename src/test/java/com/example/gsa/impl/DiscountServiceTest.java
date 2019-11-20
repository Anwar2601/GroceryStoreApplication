package com.example.gsa.impl;

import com.example.gsa.enums.ItemTypeEnum;
import com.example.gsa.enums.UserTypeEnum;
import com.example.gsa.models.Bill;
import com.example.gsa.models.Item;
import com.example.gsa.models.User;
import com.example.gsa.service.UserService;
import com.example.gsa.service.impl.DiscountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class DiscountServiceTest {

    @InjectMocks
    private DiscountService discountService;

    @Mock
    private UserService userServiceImpl;

    @Test
    public void testForEmployee(){
        Optional<User> user = Optional.of(new User(UUID.randomUUID(),"","", LocalDate.now(), UserTypeEnum.EMPLOYEE));
        Mockito.when(userServiceImpl.getUser(Mockito.any())).thenReturn(user);
        Mockito.when(userServiceImpl.checkUserType(Mockito.any())).thenReturn(Boolean.TRUE);

        List<Item> items = new ArrayList<>();
        Item item = new Item(101,"ItemName", ItemTypeEnum.GROCERY, 100, 1, 100);
        items.add(item);
        Bill bill = new Bill(UUID.randomUUID(),UUID.randomUUID(),100.0,items);
        double discount = discountService.getDiscount(bill);
        Assert.isTrue(discount==5.0,"Test Failed");
    }

    @Test
    public void testForEmployeeWithoutGroceryItems(){
        Optional<User> user = Optional.of(new User(UUID.randomUUID(),"","", LocalDate.now(), UserTypeEnum.EMPLOYEE));
        Mockito.when(userServiceImpl.getUser(Mockito.any())).thenReturn(user);
        Mockito.when(userServiceImpl.checkUserType(Mockito.any())).thenReturn(Boolean.TRUE);

        List<Item> items = new ArrayList<>();
        Item item = new Item(101,"ItemName", ItemTypeEnum.PERSONALCARE, 100, 1, 100);
        items.add(item);
        Bill bill = new Bill(UUID.randomUUID(),UUID.randomUUID(),100.0,items);
        double discount = discountService.getDiscount(bill);
        Assert.isTrue(discount==35.0,"Test Failed");
    }

    @Test
    public void testForCustomer(){
        Optional<User> user = Optional.of(new User(UUID.randomUUID(),"","", LocalDate.now(), UserTypeEnum.CUSTOMER));
        Mockito.when(userServiceImpl.getUser(Mockito.any())).thenReturn(user);
        Mockito.when(userServiceImpl.checkUserType(Mockito.any())).thenReturn(Boolean.FALSE);

        List<Item> items = new ArrayList<>();
        Item item = new Item(101,"ItemName", ItemTypeEnum.PERSONALCARE, 100, 1, 100);
        items.add(item);
        Bill bill = new Bill(UUID.randomUUID(),UUID.randomUUID(),100.0,items);
        double discount = discountService.getDiscount(bill);
        Assert.isTrue(discount==15.0,"Test Failed");
    }

    @Test
    public void testForOldCustomer(){
        Mockito.when(userServiceImpl.getUser(Mockito.any())).thenReturn(Optional.empty());
        Mockito.when(userServiceImpl.checkUserType(Mockito.any())).thenReturn(Boolean.FALSE);
        Mockito.when(userServiceImpl.checkUserJoiningDate(Mockito.any())).thenReturn(Boolean.TRUE);

        List<Item> items = new ArrayList<>();
        Item item = new Item(101,"ItemName", ItemTypeEnum.PERSONALCARE, 100, 1, 100);
        items.add(item);
        Bill bill = new Bill(UUID.randomUUID(),UUID.randomUUID(),100.0,items);
        double discount = discountService.getDiscount(bill);
        Assert.isTrue(discount==10.0,"Test Failed");
    }
}
