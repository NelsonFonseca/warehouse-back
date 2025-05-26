package com.warehouse.warehouse.web;

import com.warehouse.warehouse.domain.service.RackService;
import com.warehouse.warehouse.persistence.entity.Rack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/racks")
public class RackController {

    @Autowired
    private RackService rackService;

    @PostMapping
    public Rack createRack(@RequestBody Rack rack) {
        return rackService.createRack(rack);
    }

    @PutMapping("/{id}")
    public Rack updateRack(@PathVariable Integer id, @RequestBody Rack rack) {
        rack.setId(id);
        return rackService.updateRack(rack);
    }

    @DeleteMapping("/{id}")
    public void deleteRack(@PathVariable Integer id) {
        rackService.deleteRack(id);
    }

    @GetMapping("/{id}")
    public Rack getRackById(@PathVariable Integer id) {
        return rackService.getRackById(id);
    }

    @GetMapping
    public List<Rack> getAllRacks() {
        return rackService.getAllRacks();
    }
}
