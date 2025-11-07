package com.he181672.supermarketsystem.controller;

import com.he181672.supermarketsystem.dto.CartDTO;
import com.he181672.supermarketsystem.entity.CartItem;
import com.he181672.supermarketsystem.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartController {
    private final CartItemService cartItemService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CartDTO dto) {
        return ResponseEntity.ok(cartItemService.addProductToCartItem(dto));
    }

    @GetMapping
    public ResponseEntity<?> getAllCartItems(@RequestParam(required = false) Integer userId) {
        List<CartDTO> listCart = cartItemService.getAllCartItems(userId);
        return ResponseEntity.ok(listCart);
    }

    @GetMapping("/count")
    public ResponseEntity<?> countCartItems(@RequestParam(required = false) Integer userId) {
        List<CartDTO> listCart = cartItemService.getAllCartItems(userId);
        int count = listCart.size();
        return ResponseEntity.ok(count);
    }
}
