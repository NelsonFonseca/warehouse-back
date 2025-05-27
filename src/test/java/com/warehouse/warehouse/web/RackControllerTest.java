package com.warehouse.warehouse.web;

import com.warehouse.warehouse.domain.service.RackService;
import com.warehouse.warehouse.persistence.entity.Rack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RackControllerTest {

    @Mock
    private RackService rackService;

    @InjectMocks
    private RackController rackController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateRack() {
        Rack rack = new Rack();
        rack.setUuid("rack-001");
        rack.setType("A");
        rack.setWarehouse(1);

        when(rackService.createRack(rack)).thenReturn(rack);

        Rack result = rackController.createRack(rack);
        assertEquals("rack-001", result.getUuid());
        verify(rackService, times(1)).createRack(rack);
    }

    @Test
    void testGetAllRacks() {
        List<Rack> racks = Arrays.asList(new Rack(), new Rack());
        when(rackService.getAllRacks()).thenReturn(racks);

        List<Rack> result = rackController.getAllRacks();
        assertEquals(2, result.size());
        verify(rackService, times(1)).getAllRacks();
    }

    @Test
    void testGetRackById() {
        Rack rack = new Rack();
        rack.setId(1);
        when(rackService.getRackById(1)).thenReturn(rack);

        Rack result = rackController.getRackById(1);
        assertEquals(1, result.getId());
        verify(rackService, times(1)).getRackById(1);
    }

    @Test
    void testUpdateRack() {
        Rack rack = new Rack();
        rack.setId(1);
        rack.setType("B");

        when(rackService.updateRack(rack)).thenReturn(rack);

        Rack result = rackController.updateRack(1, rack);
        assertEquals("B", result.getType());
        verify(rackService, times(1)).updateRack(rack);
    }

    @Test
    void testDeleteRack() {
        rackController.deleteRack(1);
        verify(rackService, times(1)).deleteRack(1);
    }

    @Test
    void testGetAllRacksByWarehouse() {
        List<Rack> racks = Arrays.asList(new Rack(), new Rack());
        when(rackService.getAllRacksByWarehouse(1)).thenReturn(racks);

        List<Rack> result = rackController.getAllRacksByWarehouse(1);
        assertEquals(2, result.size());
        verify(rackService, times(1)).getAllRacksByWarehouse(1);
    }
}
