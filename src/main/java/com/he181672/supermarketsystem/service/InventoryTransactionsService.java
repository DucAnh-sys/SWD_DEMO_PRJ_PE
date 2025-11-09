package com.he181672.supermarketsystem.service;

import com.he181672.supermarketsystem.dto.InventoryTransactionsDTO;

import java.util.List;

public interface InventoryTransactionsService {
    List<InventoryTransactionsDTO> getAllInventoryTransactions();
}
