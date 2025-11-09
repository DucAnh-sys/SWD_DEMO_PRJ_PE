package com.he181672.supermarketsystem.controller;

import com.he181672.supermarketsystem.dto.InventoryTransactionsDTO;
import com.he181672.supermarketsystem.entity.InventoryTransaction;
import com.he181672.supermarketsystem.service.InventoryTransactionsService;
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
public class InventoryTransactionsController {
    private final InventoryTransactionsService inventoryTransactionsService;

    @GetMapping("/admin/inventory-transactions")
    public ResponseEntity<List<InventoryTransactionsDTO>> getInventoryTransactions() {
        List<InventoryTransactionsDTO> list = inventoryTransactionsService.getAllInventoryTransactions();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
