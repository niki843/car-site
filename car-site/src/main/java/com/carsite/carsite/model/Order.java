package com.carsite.carsite.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "\"order\"")
public class Order {

    @Id
    @Column(columnDefinition = "VARCHAR(512)", unique = true)
    @NotNull
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;

    @Column(name="product_count")
    @NotNull
    private int productCount;

    @ManyToOne
    @JoinColumn(name= "order_group_id")
    @NotNull
    private OrderGroup orderGroup;

}
