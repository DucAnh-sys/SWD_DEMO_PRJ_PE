package com.he181672.supermarketsystem.controller;

import com.he181672.supermarketsystem.entity.ProductCategory;
import com.he181672.supermarketsystem.repository.ProductCategoryRepository;
import com.he181672.supermarketsystem.service.impl.ProductCategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class ProductCategoryController {
    private final ProductCategoryServiceImpl productCategoryService;
    @GetMapping
    public ResponseEntity<List<ProductCategory>> getProductCategory() {
        List<ProductCategory> productCategoryList = productCategoryService.getAllCategory();
        System.out.println(productCategoryList);
        return ResponseEntity.ok(productCategoryList);
    }
}
