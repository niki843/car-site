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
public class OrderGroup {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(columnDefinition = "VARCHAR(512)", unique = true)
    @NotNull
    private String id;

    @Column(name = "group_price", columnDefinition = "double")
    private double groupPrice;

    @Column(name = "products_amount", columnDefinition = "int2")
    private int productsAmount;

}
