package com.he181672.supermarketsystem.service.impl;

import com.he181672.supermarketsystem.repository.ProductRepository;
import com.he181672.supermarketsystem.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.he181672.supermarketsystem.entity.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
