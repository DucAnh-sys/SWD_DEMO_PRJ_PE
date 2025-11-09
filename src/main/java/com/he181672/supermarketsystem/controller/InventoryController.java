package com.he181672.supermarketsystem.controller;

import com.he181672.supermarketsystem.dto.InventoryDTO;
import com.he181672.supermarketsystem.entity.Inventory;
import com.he181672.supermarketsystem.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/admin/inventory")
    public ResponseEntity<List<InventoryDTO>> getInventory() {
        List<InventoryDTO> listInventoryDTO = inventoryService.getAllInventory();
        return new ResponseEntity<>(listInventoryDTO, HttpStatus.OK);
    }
    
    @PutMapping("/admin/inventory/{inventoryId}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable int inventoryId,
                                                     @RequestBody InventoryDTO inventoryDTO) {
        Inventory inventory = inventoryService.updateInventory(inventoryId,inventoryDTO);
        return ResponseEntity.ok().body(inventory);
    }
}
