package com.warehouse.warehouse.domain.service;

import com.warehouse.warehouse.persistence.entity.Rack;

import java.util.List;

public interface RackService {

    public Rack createRack(Rack rack);
    public Rack updateRack(Rack rack);
    public void deleteRack(Integer id);
    public Rack getRackById(Integer id);
    public List<Rack> getAllRacks();
}
