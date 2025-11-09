package com.he181672.supermarketsystem.service.impl;

import com.he181672.supermarketsystem.dto.OrderDTO;
import com.he181672.supermarketsystem.entity.*;
import com.he181672.supermarketsystem.repository.*;
import com.he181672.supermarketsystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    @Override
    public void createOrder(OrderDTO orderdto) {
        User user = userRepository.findUserByUserId(orderdto.getUserId());
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Order order= Order.builder()
                .paymentMethod("Cart")
                .status(Order.OrderStatus.Pending)
                .user(user)
                .totalAmount(orderdto.getTotalPrice())
                .deliveryStatus(Order.DeliveryStatus.Pending)
                .deliveryAddress(user.getAddress())
                .orderDate(LocalDateTime.now()).build();

        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderDTO.OrderItemRequest itemRequest: orderdto.getItems()){
            Product product = productRepository.findProductByProductId(itemRequest.getProductId());
            if (product == null) {
                throw new  RuntimeException("product not found");
            }
            cartItemRepository.deleteById(itemRequest.getCartItemId());
            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(product)
                    .quantity(itemRequest.getQuantity())
                    .unitPrice(itemRequest.getQuantity() * product.getPrice())
                    .discount(null).build();
            orderItems.add(orderItem);

        }
        double price = user.getBalance() - orderdto.getTotalPrice();
        price = Math.round(price * 100.0) / 100.0;
        user.setBalance(price);

        order.setOrderItems(orderItems);
        orderRepository.save(order);
    }


}
