package com.he181672.supermarketsystem.service;

import com.he181672.supermarketsystem.dto.InventoryDTO;
import com.he181672.supermarketsystem.dto.ProductDTO;
import com.he181672.supermarketsystem.entity.Inventory;
import com.he181672.supermarketsystem.entity.Product;

import java.util.List;

public interface InventoryService {
    List<InventoryDTO> getAllInventory();

    Inventory updateInventory(int id, InventoryDTO inventoryDTO);

    void createInitialInventory(Product product, int quantity, int minQuantity);
}
