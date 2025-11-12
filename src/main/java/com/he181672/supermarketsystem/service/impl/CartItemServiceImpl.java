package com.he181672.supermarketsystem.service.impl;

import com.he181672.supermarketsystem.dto.CartDTO;
import com.he181672.supermarketsystem.entity.CartItem;
import com.he181672.supermarketsystem.entity.Product;
import com.he181672.supermarketsystem.entity.User;
import com.he181672.supermarketsystem.repository.CartItemRepository;
import com.he181672.supermarketsystem.repository.ProductRepository;
import com.he181672.supermarketsystem.repository.UserRepository;
import com.he181672.supermarketsystem.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    @Override
    public CartItem addProductToCartItem(CartDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem existing = cartItemRepository
                .findCartItemByUserAndProduct(user, product);

        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + dto.getQuantity());
            return cartItemRepository.save(existing);
        }

        CartItem cartItem = new CartItem();
        cartItem.setUser(user);
        cartItem.setProduct(product);
        cartItem.setQuantity(dto.getQuantity());
        cartItem.setUnitPrice(product.getPrice() * dto.getQuantity());
        cartItem.setAddedAt(LocalDateTime.now());
        return cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartDTO> getAllCartItems(Integer userId) {
        User user = userRepository.findUserByUserId(userId);
        List<CartItem> cartItems = cartItemRepository.findCartItemByUser(user);
        List<CartDTO> cartDTOList = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            CartDTO cartDTO = new CartDTO();
            cartDTO.setCartId(cartItem.getCartItemId());
            cartDTO.setUserId(userId);
            cartDTO.setProductId(cartItem.getProduct().getProductId());
            cartDTO.setDescription(cartItem.getProduct().getDescription());
            cartDTO.setQuantity(cartItem.getQuantity());
            cartDTO.setProductName(cartItem.getProduct().getProductName());
            cartDTO.setPrice(cartItem.getUnitPrice());;
            cartDTOList.add(cartDTO);
        }
        return cartDTOList;
    }

}
