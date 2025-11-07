package com.he181672.supermarketsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartDTO {
    private int userId;
    private int productId;
    private int quantity;
    private String productName;
    private String description;
    private double price;
}
