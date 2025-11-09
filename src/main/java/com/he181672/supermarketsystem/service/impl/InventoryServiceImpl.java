package com.he181672.supermarketsystem.service.impl;

import com.he181672.supermarketsystem.dto.InventoryDTO;
import com.he181672.supermarketsystem.entity.Inventory;
import com.he181672.supermarketsystem.repository.InventoryRepository;
import com.he181672.supermarketsystem.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;
    @Override
    public List<InventoryDTO> getAllInventory() {
        List<Inventory> inventoryList = inventoryRepository.findAll();

        return inventoryList.stream().map(inventory -> {
            InventoryDTO inventoryDTO = new InventoryDTO();
            inventoryDTO.setInventoryId(inventory.getInventoryId());
            inventoryDTO.setQuantity(inventory.getQuantity());
            inventoryDTO.setMinQuantity(inventory.getMinQuantity());
            inventoryDTO.setProductId(inventory.getProduct().getProductId());
            inventoryDTO.setProductName(inventory.getProduct().getProductName());

            if (inventory.getProduct().getSupplier() != null) {
                inventoryDTO.setSupplierName(inventory.getProduct().getSupplier().getSupplierName());
            } else {
                inventoryDTO.setSupplierName("Unknown Supplier");
            }

            return inventoryDTO;
        }).collect(Collectors.toList());
    }

}
