package com.he181672.supermarketsystem.service;

import com.he181672.supermarketsystem.dto.CartDTO;
import com.he181672.supermarketsystem.entity.CartItem;

import java.util.List;

public interface CartItemService {
    CartItem addProductToCartItem(CartDTO cartDTO);

    List<CartDTO> getAllCartItems(Integer userId);
}
