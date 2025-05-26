package com.warehouse.warehouse.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Warehouse {
    @Id
    @GeneratedValue
    private Integer id;
    private String uuid;
    private String client;
    private String family; // EST o ROB
    private Integer size;
}

