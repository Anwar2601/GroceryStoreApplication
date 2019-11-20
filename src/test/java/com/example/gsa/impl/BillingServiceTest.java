package com.example.gsa.impl;

import com.example.gsa.enums.ItemTypeEnum;
import com.example.gsa.enums.UserTypeEnum;
import com.example.gsa.factory.UserFactory;
import com.example.gsa.models.Bill;
import com.example.gsa.models.Item;
import com.example.gsa.models.User;
import com.example.gsa.respositories.UserRepository;
import com.example.gsa.service.UserService;
import com.example.gsa.service.impl.BillingService;
import com.example.gsa.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
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
public class BillingServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserFactory userFactory;

    @Mock
    private UserService userService;

    @InjectMocks
    private BillingService billingService;

    @BeforeEach
    public void before(){
        Optional<User> user = Optional.of(new User(UUID.randomUUID(),"","", LocalDate.now(), UserTypeEnum.EMPLOYEE));
        Mockito.when(userRepository.getUser(Mockito.any())).thenReturn(user);
        Mockito.when(userFactory.getUserService(Mockito.any())).thenReturn(new EmployeeServiceImpl());
    }

    @Test
    void testProcessBill(){
        Mockito.when(userService.calculateDiscount(Mockito.any())).thenReturn(5.0);
        List<Item> items = new ArrayList<>();
        Item item = new Item(101,"ItemName", ItemTypeEnum.GROCERY, 100, 1, 100);
        items.add(item);
        Bill bill = new Bill(UUID.randomUUID(), UUID.randomUUID(), 100.0, items);
        double payableAmount = billingService.processBill(bill);
        Assert.isTrue(payableAmount==95.0,"Test Failed");
    }
}
