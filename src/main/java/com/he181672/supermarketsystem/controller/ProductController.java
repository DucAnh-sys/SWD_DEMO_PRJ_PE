package com.he181672.supermarketsystem.controller;

import com.he181672.supermarketsystem.dto.ProductDTO;
import com.he181672.supermarketsystem.entity.Product;
import com.he181672.supermarketsystem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
    @PostMapping("/admin/addProducts")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO dto) {
        System.out.println(dto.toString());
        Product product = productService.addNewProduct(dto);
        return ResponseEntity.ok(product);
    }
}
