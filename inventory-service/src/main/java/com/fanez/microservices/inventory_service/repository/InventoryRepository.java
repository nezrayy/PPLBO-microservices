package com.fanez.microservices.inventory_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanez.microservices.inventory_service.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    boolean existsBySkuCodeAndQuantityGreaterThanEqual(String skuCode, int quantity);
}
