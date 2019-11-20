package com.example.gsa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    private UUID billId;
    private UUID userId;
    private double amount;
    private List<Item> items;
}
