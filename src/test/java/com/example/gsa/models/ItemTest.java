package com.example.gsa.models;

import com.example.gsa.enums.ItemTypeEnum;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class ItemTest {

    @InjectMocks
    private Item item;

    @Test
    public void testGetterSetters(){
        Item item = new Item();
        item.setItemId(101);
        item.setAmount(100.0);
        item.setItemType(ItemTypeEnum.PERSONALCARE);
        item.setItemName("");
        item.setQty(1);
        item.setRate(100);
        double amount = item.getAmount();
        ItemTypeEnum itemType = item.getItemType();
        String itemName = item.getItemName();
        int itemId = item.getItemId();
        int qty = item.getQty();
        double rate = item.getRate();
        Assert.isTrue(itemType==ItemTypeEnum.PERSONALCARE
                &&amount==100.0
                &&itemName!=null
                &&itemId==101
                &&qty==1
                &&rate==100,"Test Failed");
    }

}
