package com.he181672.supermarketsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String productName;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double price;

    private Integer stockQuantity;

    private Boolean isDeleted;

    private Integer status; // 1 = Available, 0 = Out of Stock

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;
}
