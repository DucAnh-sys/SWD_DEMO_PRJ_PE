package com.he181672.supermarketsystem.service.impl;

import com.he181672.supermarketsystem.dto.ProductDTO;
import com.he181672.supermarketsystem.entity.Inventory;
import com.he181672.supermarketsystem.entity.ProductCategory;
import com.he181672.supermarketsystem.entity.Supplier;
import com.he181672.supermarketsystem.repository.*;
import com.he181672.supermarketsystem.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.he181672.supermarketsystem.entity.Product;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final InventoryServiceImpl inventoryService;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addNewProduct(ProductDTO dto) {
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getProductPrice());
        product.setIsDeleted(false);
        product.setStatus(true);
        product.setCategory(
                productCategoryRepository.findById(dto.getCategoryId())
                        .orElseThrow(() -> new RuntimeException("Category not found"))
        );

        // lấy supplier
        product.setSupplier(
                supplierRepository.findById(dto.getSupplierId())
                        .orElseThrow(() -> new RuntimeException("Supplier not found"))
        );

        productRepository.save(product);

        // ✅ gọi inventory service để tạo inventory
        inventoryService.createInitialInventory(product, dto.getQuantity(), dto.getMinQuantity());

        return product;
    }

}
