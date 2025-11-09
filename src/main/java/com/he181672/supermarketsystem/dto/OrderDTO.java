package com.he181672.supermarketsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer userId;
    private double totalPrice;
    private List<OrderItemRequest> items;

    @Data
    public static class OrderItemRequest {
        private Integer cartItemId;
        private Integer productId;
        private Integer quantity;
    }
}
