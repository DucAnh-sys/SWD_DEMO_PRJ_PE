package com.he181672.supermarketsystem.repository;


import com.he181672.supermarketsystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findProductByProductId(Integer productId);
}
