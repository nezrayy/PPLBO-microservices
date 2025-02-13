package com.fanez.microservices.order_service.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fanez.microservices.order_service.dto.OrderRequest;
import com.fanez.microservices.order_service.model.Order;
import com.fanez.microservices.order_service.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest) {
        //map OrderRquest to Order object
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());

        //save Order object to OrderRepository
        orderRepository.save(order);
    }
}
