package com.warehouse.warehouse.web;

import com.warehouse.warehouse.domain.service.WarehouseService;
import com.warehouse.warehouse.persistence.entity.Warehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WarehouseControllerTest {

    @Mock
    private WarehouseService warehouseService;

    @InjectMocks
    private WarehouseController warehouseController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateWarehouse() {
        Warehouse warehouse = new Warehouse();
        warehouse.setUuid("uuid-001");
        warehouse.setClient("Cliente A");
        warehouse.setFamily("EST");
        warehouse.setSize(3);

        when(warehouseService.createWarehouse(warehouse)).thenReturn(warehouse);

        Warehouse result = warehouseController.createWarehouse(warehouse);
        assertEquals("uuid-001", result.getUuid());
        verify(warehouseService, times(1)).createWarehouse(warehouse);
    }

    @Test
    void testGetWarehouseById() {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);
        when(warehouseService.getWarehouseById(1)).thenReturn(warehouse);

        Warehouse result = warehouseController.getWarehouseById(1);
        assertEquals(1, result.getId());
        verify(warehouseService, times(1)).getWarehouseById(1);
    }

    @Test
    void testGetAllWarehouses() {
        List<Warehouse> warehouses = Arrays.asList(new Warehouse(), new Warehouse());
        when(warehouseService.getAllWarehouses()).thenReturn(warehouses);

        List<Warehouse> result = warehouseController.getAllWarehouses();
        assertEquals(2, result.size());
        verify(warehouseService, times(1)).getAllWarehouses();
    }

    @Test
    void testUpdateWarehouse() {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);
        warehouse.setClient("Cliente B");

        when(warehouseService.updateWarehouse(warehouse)).thenReturn(warehouse);

        Warehouse result = warehouseController.updateWarehouse(1, warehouse);
        assertEquals("Cliente B", result.getClient());
        verify(warehouseService, times(1)).updateWarehouse(warehouse);
    }

    @Test
    void testDeleteWarehouse() {
        warehouseController.deleteWarehouse(1);
        verify(warehouseService, times(1)).deleteWarehouse(1);
    }
}
