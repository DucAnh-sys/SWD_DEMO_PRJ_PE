package com.he181672.supermarketsystem.service;

import com.he181672.supermarketsystem.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    List<InventoryDTO> getAllInventory();
}
