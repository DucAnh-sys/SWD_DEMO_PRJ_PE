package com.he181672.supermarketsystem.controller;

import com.he181672.supermarketsystem.dto.InventoryDTO;
import com.he181672.supermarketsystem.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
