package com.warehouse.warehouse.persistence.repository;

import com.warehouse.warehouse.persistence.entity.Rack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RackRepository extends JpaRepository<Rack, Integer> {
}

