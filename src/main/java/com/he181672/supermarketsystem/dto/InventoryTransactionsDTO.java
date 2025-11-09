package com.he181672.supermarketsystem.dto;

import com.he181672.supermarketsystem.entity.InventoryTransaction.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryTransactionsDTO {

    private int inventoryTransactionId;
    private int productId;
    private String productName;
    private double quantity;
    private TransactionType transactionType;
    private LocalDateTime transactionDate;
    private String notes;
}
