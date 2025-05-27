package com.warehouse.warehouse.persistence.repository;

import com.warehouse.warehouse.persistence.entity.Rack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RackRepository extends JpaRepository<Rack, Integer> {


    @Query("SELECT r FROM Rack r WHERE r.warehouse = :warehouseId")
    List<Rack> findByWarehouseId(Integer warehouseId);


}

