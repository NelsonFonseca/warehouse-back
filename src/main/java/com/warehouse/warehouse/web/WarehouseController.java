package com.warehouse.warehouse.web;

import com.warehouse.warehouse.domain.service.WarehouseService;
import com.warehouse.warehouse.persistence.entity.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping
    public Warehouse createWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.createWarehouse(warehouse);
    }

    @PutMapping("/{id}")
    public Warehouse updateWarehouse(@PathVariable Integer id, @RequestBody Warehouse warehouse) {
        warehouse.setId(id);
        return warehouseService.updateWarehouse(warehouse);
    }

    @DeleteMapping("/{id}")
    public void deleteWarehouse(@PathVariable Integer id) {
        warehouseService.deleteWarehouse(id);
    }

    @GetMapping("/{id}")
    public Warehouse getWarehouseById(@PathVariable Integer id) {
        return warehouseService.getWarehouseById(id);
    }

    @GetMapping
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }
}
