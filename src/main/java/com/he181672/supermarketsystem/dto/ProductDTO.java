package com.he181672.supermarketsystem.dto;

import com.he181672.supermarketsystem.entity.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String productName;
    private double productPrice;
    private int supplierId;
    private int quantity;
    private int minQuantity;
    private String description;
    private int categoryId;
}
