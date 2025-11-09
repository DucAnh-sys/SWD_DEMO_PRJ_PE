package com.he181672.supermarketsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDTO {
    private int inventoryId;
    private int productId;
    private String productName;
    private String supplierName;
    private double quantity;
    private double minQuantity;
    private LocalDateTime lastUpdated;
}
