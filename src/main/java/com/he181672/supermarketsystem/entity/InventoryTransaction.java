package com.he181672.supermarketsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventory_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private Double quantity;

    private java.time.LocalDateTime transactionDate;

    private String notes;

    public enum TransactionType {
        IN, OUT
    }
}
