package com.he181672.supermarketsystem.service.impl;

import com.he181672.supermarketsystem.dto.InventoryDTO;
import com.he181672.supermarketsystem.entity.Inventory;
import com.he181672.supermarketsystem.entity.Product;
import com.he181672.supermarketsystem.repository.InventoryRepository;
import com.he181672.supermarketsystem.repository.ProductRepository;
import com.he181672.supermarketsystem.service.InventoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;
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
            inventoryDTO.setSupplierName(inventory.getProduct().getSupplier().getSupplierName());
            inventoryDTO.setLastUpdated(inventory.getLastUpdated());
            if (inventory.getProduct().getSupplier() != null) {
                inventoryDTO.setSupplierName(inventory.getProduct().getSupplier().getSupplierName());
            } else {
                inventoryDTO.setSupplierName("Unknown Supplier");
            }

            return inventoryDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public Inventory updateInventory(int inventoryId, InventoryDTO inventoryDTO) {
        Inventory inventory = inventoryRepository.findInventoryByInventoryId(inventoryId);
        if (inventory == null) {
            throw new EntityNotFoundException("Inventory Not Found");

        }

        inventory.setQuantity(inventoryDTO.getQuantity());
        inventory.setMinQuantity(inventoryDTO.getMinQuantity());
        inventory.setLastUpdated(LocalDateTime.now());
        Product product = inventory.getProduct();
        if (product == null) {
            throw new EntityNotFoundException("Product Not Found in Inventory");
        }
        product.setProductName(inventoryDTO.getProductName());
        productRepository.save(product);
        return inventoryRepository.save(inventory);
    }

}
