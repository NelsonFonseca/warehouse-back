package com.warehouse.warehouse.persistence.repository;

import com.warehouse.warehouse.persistence.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
}

