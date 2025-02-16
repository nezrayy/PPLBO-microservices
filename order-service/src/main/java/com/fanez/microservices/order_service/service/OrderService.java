package com.fanez.microservices.order_service.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fanez.microservices.order_service.client.InventoryClient;
import com.fanez.microservices.order_service.dto.OrderRequest;
import com.fanez.microservices.order_service.model.Order;
import com.fanez.microservices.order_service.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    public void placeOrder(OrderRequest orderRequest) {
        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        
        if (isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
    
            //save Order object to OrderRepository
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product with skuCode " + orderRequest.skuCode() + " is out of stock.");
        }
    }
}
