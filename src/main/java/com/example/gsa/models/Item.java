package com.example.gsa.models;

import com.example.gsa.enums.ItemTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private int itemId;
    private String itemName;
    private ItemTypeEnum itemType;
    private double rate;
    private int qty;
    private double amount;
}
