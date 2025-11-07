package com.he181672.supermarketsystem.service.impl;

import com.he181672.supermarketsystem.entity.ProductCategory;
import com.he181672.supermarketsystem.repository.ProductCategoryRepository;
import com.he181672.supermarketsystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements CategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> getAllCategory() {
        return productCategoryRepository.findAll();
    }
}
