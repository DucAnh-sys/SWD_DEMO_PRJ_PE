package com.he181672.supermarketsystem.service.impl;

import com.he181672.supermarketsystem.dto.InventoryTransactionsDTO;
import com.he181672.supermarketsystem.entity.InventoryTransaction;
import com.he181672.supermarketsystem.repository.InventoryTransactionsRepository;
import com.he181672.supermarketsystem.service.InventoryTransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryTransactionsServiceImpl implements InventoryTransactionsService {
    private final InventoryTransactionsRepository inventoryTransactionsRepository;
    @Override
    public List<InventoryTransactionsDTO> getAllInventoryTransactions() {
        List<InventoryTransaction> listTransactions = inventoryTransactionsRepository.findAll();
        return listTransactions.stream().map( transaction ->{
            InventoryTransactionsDTO inventoryTransactionsDTO = new InventoryTransactionsDTO();
            inventoryTransactionsDTO.setInventoryTransactionId(transaction.getTransactionId());
            inventoryTransactionsDTO.setTransactionDate(transaction.getTransactionDate());
            inventoryTransactionsDTO.setTransactionType(transaction.getTransactionType());
            inventoryTransactionsDTO.setQuantity(transaction.getQuantity());
            inventoryTransactionsDTO.setProductId(transaction.getProduct().getProductId());
            inventoryTransactionsDTO.setProductName(transaction.getProduct().getProductName());
            inventoryTransactionsDTO.setNotes(transaction.getNotes());
            return inventoryTransactionsDTO;
        }).collect(Collectors.toList());
    }
}
