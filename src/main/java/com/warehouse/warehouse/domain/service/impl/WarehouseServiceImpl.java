package com.warehouse.warehouse.domain.service.impl;

import com.warehouse.warehouse.domain.service.WarehouseService;
import com.warehouse.warehouse.persistence.entity.Warehouse;
import com.warehouse.warehouse.persistence.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public Warehouse updateWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public void deleteWarehouse(Integer id) {
        warehouseRepository.deleteById(id);
    }

    public Warehouse getWarehouseById(Integer id) {
        return warehouseRepository.findById(id).orElse(null);
    }

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }
}
