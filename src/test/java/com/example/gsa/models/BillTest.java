package com.example.gsa.models;

import com.example.gsa.enums.ItemTypeEnum;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class BillTest {

    @InjectMocks
    private Bill bill;

    @Test
    public void testGetterSetters(){
        List<Item> items = new ArrayList<>();
        Item item = new Item(101,"ItemName", ItemTypeEnum.PERSONALCARE, 100, 1, 100);
        items.add(item);
        Bill bill = new Bill();
        bill.setBillId(UUID.randomUUID());
        bill.setAmount(100.0);
        bill.setItems(items);
        bill.setUserId(UUID.randomUUID());
        double amount = bill.getAmount();
        List<Item> items1 = bill.getItems();
        UUID userId = bill.getUserId();
        UUID billId = bill.getBillId();
        Assert.isTrue(amount==item.getAmount()
                &&items1.equals(bill.getItems())
                &&userId!=null
                &&billId!=null,"Test Failed");
    }
}
