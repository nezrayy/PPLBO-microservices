package com.fanez.microservices.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanez.microservices.order_service.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Order findByOrderNumber(String orderNumber);

}
