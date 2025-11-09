package com.he181672.supermarketsystem.service;
import com.he181672.supermarketsystem.dto.ProductDTO;
import com.he181672.supermarketsystem.entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product addNewProduct(ProductDTO productdto);
}
