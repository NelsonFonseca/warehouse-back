package com.warehouse.warehouse.domain.service.impl;

import com.warehouse.warehouse.persistence.entity.Warehouse;
import com.warehouse.warehouse.persistence.repository.WarehouseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WarehouseServiceImplTest {

    @Mock
    private WarehouseRepository warehouseRepository;

    @InjectMocks
    private WarehouseServiceImpl warehouseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateWarehouse() {
        Warehouse warehouse = new Warehouse();
        warehouse.setUuid("uuid-001");

        when(warehouseRepository.save(warehouse)).thenReturn(warehouse);

        Warehouse result = warehouseService.createWarehouse(warehouse);
        assertEquals("uuid-001", result.getUuid());
        verify(warehouseRepository, times(1)).save(warehouse);
    }

    @Test
    void testUpdateWarehouse() {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);
        warehouse.setClient("Cliente B");

        when(warehouseRepository.save(warehouse)).thenReturn(warehouse);

        Warehouse result = warehouseService.updateWarehouse(warehouse);
        assertEquals("Cliente B", result.getClient());
        verify(warehouseRepository, times(1)).save(warehouse);
    }

    @Test
    void testDeleteWarehouse() {
        warehouseService.deleteWarehouse(1);
        verify(warehouseRepository, times(1)).deleteById(1);
    }

    @Test
    void testGetWarehouseById() {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);

        when(warehouseRepository.findById(1)).thenReturn(Optional.of(warehouse));

        Warehouse result = warehouseService.getWarehouseById(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(warehouseRepository, times(1)).findById(1);
    }

    @Test
    void testGetAllWarehouses() {
        List<Warehouse> warehouses = Arrays.asList(new Warehouse(), new Warehouse());
        when(warehouseRepository.findAll()).thenReturn(warehouses);

        List<Warehouse> result = warehouseService.getAllWarehouses();
        assertEquals(2, result.size());
        verify(warehouseRepository, times(1)).findAll();
    }
}
