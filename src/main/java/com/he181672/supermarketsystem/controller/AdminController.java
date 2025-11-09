package com.he181672.supermarketsystem.controller;

import com.he181672.supermarketsystem.dto.InventoryDTO;
import com.he181672.supermarketsystem.dto.InventoryTransactionsDTO;
import com.he181672.supermarketsystem.dto.ProductDTO;
import com.he181672.supermarketsystem.dto.UserDTO;
import com.he181672.supermarketsystem.entity.Inventory;
import com.he181672.supermarketsystem.entity.Product;
import com.he181672.supermarketsystem.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {
    private final InventoryService inventoryService;
    private final InventoryTransactionsService inventoryTransactionsService;
    private final ProductService productService;
    private final RechargeRequestService rechargeRequestService;
    private final UserService userService;
    @GetMapping("/users")
    public ResponseEntity<?> getAdminUser() {
        List<UserDTO> userDTOS =userService.manageUsers();
        return ResponseEntity.ok(userDTOS);
    }
    @GetMapping("/request")
    public ResponseEntity<?> getAllRequest() {
        return ResponseEntity.ok(rechargeRequestService.getAllRechargeRequests());
    }
    @PostMapping("/addProducts")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO dto) {
        System.out.println(dto.toString());
        Product product = productService.addNewProduct(dto);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/inventory-transactions")
    public ResponseEntity<List<InventoryTransactionsDTO>> getInventoryTransactions() {
        List<InventoryTransactionsDTO> list = inventoryTransactionsService.getAllInventoryTransactions();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<InventoryDTO>> getInventory() {
        List<InventoryDTO> listInventoryDTO = inventoryService.getAllInventory();
        return new ResponseEntity<>(listInventoryDTO, HttpStatus.OK);
    }


    @PutMapping("/inventory/{inventoryId}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable int inventoryId,
                                                     @RequestBody InventoryDTO inventoryDTO) {
        Inventory inventory = inventoryService.updateInventory(inventoryId,inventoryDTO);
        return ResponseEntity.ok().body(inventory);
    }
}
