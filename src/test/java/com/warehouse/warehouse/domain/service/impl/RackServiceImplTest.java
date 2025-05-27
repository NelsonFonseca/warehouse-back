package com.warehouse.warehouse.domain.service.impl;

import com.warehouse.warehouse.persistence.entity.Rack;
import com.warehouse.warehouse.persistence.repository.RackRepository;
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

class RackServiceImplTest {

    @Mock
    private RackRepository rackRepository;

    @InjectMocks
    private RackServiceImpl rackService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateRack() {
        Rack rack = new Rack();
        rack.setUuid("rack-001");

        when(rackRepository.save(rack)).thenReturn(rack);

        Rack result = rackService.createRack(rack);
        assertEquals("rack-001", result.getUuid());
        verify(rackRepository, times(1)).save(rack);
    }

    @Test
    void testUpdateRack() {
        Rack rack = new Rack();
        rack.setId(1);
        rack.setType("B");

        when(rackRepository.save(rack)).thenReturn(rack);

        Rack result = rackService.updateRack(rack);
        assertEquals("B", result.getType());
        verify(rackRepository, times(1)).save(rack);
    }

    @Test
    void testDeleteRack() {
        rackService.deleteRack(1);
        verify(rackRepository, times(1)).deleteById(1);
    }

    @Test
    void testGetRackById() {
        Rack rack = new Rack();
        rack.setId(1);

        when(rackRepository.findById(1)).thenReturn(Optional.of(rack));

        Rack result = rackService.getRackById(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(rackRepository, times(1)).findById(1);
    }

    @Test
    void testGetAllRacks() {
        List<Rack> racks = Arrays.asList(new Rack(), new Rack());
        when(rackRepository.findAll()).thenReturn(racks);

        List<Rack> result = rackService.getAllRacks();
        assertEquals(2, result.size());
        verify(rackRepository, times(1)).findAll();
    }

    @Test
    void testGetAllRacksByWarehouse() {
        List<Rack> racks = Arrays.asList(new Rack(), new Rack());
        when(rackRepository.findByWarehouseId(1)).thenReturn(racks);

        List<Rack> result = rackService.getAllRacksByWarehouse(1);
        assertEquals(2, result.size());
        verify(rackRepository, times(1)).findByWarehouseId(1);
    }
}
