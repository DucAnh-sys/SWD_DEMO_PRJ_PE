package com.he181672.supermarketsystem.repository;

import com.he181672.supermarketsystem.entity.CartItem;
import com.he181672.supermarketsystem.entity.Product;
import com.he181672.supermarketsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    CartItem findCartItemByUserAndProduct(User user, Product productId);

    List<CartItem> findCartItemByUser(User user);

  //  List<CartItem> findCartItemByUser(Integer userId);
}
