package com.warehouse.warehouse.domain.service;

import com.warehouse.warehouse.persistence.entity.Warehouse;

import java.util.List;

public interface WarehouseService {

    public Warehouse createWarehouse(Warehouse warehouse);
    public Warehouse updateWarehouse(Warehouse warehouse);
    public void deleteWarehouse(Integer id);
    public Warehouse getWarehouseById(Integer id);
    public List<Warehouse> getAllWarehouses();
}
