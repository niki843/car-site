package com.carsite.carsite.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Product {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(columnDefinition = "VARCHAR(512)", unique = true)
    @NotNull
    private String id;

    private String description;

    @Column(name = "available_count", columnDefinition = "int4")
    private int availableCount;

    private Double discount;

    private Double price;

}
