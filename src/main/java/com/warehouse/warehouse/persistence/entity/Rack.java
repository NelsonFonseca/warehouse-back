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
public class Rack {
    @Id
    @GeneratedValue
    private Integer id;
    private String uuid;
    private String type; // A, B, C, D
    private Integer warehouse;

}
