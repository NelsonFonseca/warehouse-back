package com.warehouse.warehouse.domain.service.impl;


import com.warehouse.warehouse.domain.service.RackService;
import com.warehouse.warehouse.persistence.entity.Rack;
import com.warehouse.warehouse.persistence.repository.RackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RackServiceImpl implements RackService {

    @Autowired
    private RackRepository rackRepository;

    public Rack createRack(Rack rack) {
        return rackRepository.save(rack);
    }

    public Rack updateRack(Rack rack) {
        return rackRepository.save(rack);
    }

    public void deleteRack(Integer id) {
        rackRepository.deleteById(id);
    }

    public Rack getRackById(Integer id) {
        return rackRepository.findById(id).orElse(null);
    }

    public List<Rack> getAllRacks() {
        return rackRepository.findAll();
    }

    @Override
    public List<Rack> getAllRacksByWarehouse(Integer id) {
        return rackRepository.findAllByWarehouse(id);
    }
}
