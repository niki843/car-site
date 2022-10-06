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
public class Address {

    private static final long serialVersionUID = 1L;

    public Address(){

    }

    public Address(
            String id,
            String street,
            int streetNumber,
            Integer floorNumber,
            Integer apartmentNumber
    ){
        this.id = id;
        this.street = street;
        this.streetNumber = streetNumber;
        this.floorNumber = floorNumber;
        this.apartmentNumber = apartmentNumber;
    }

    @Id
    @Column(columnDefinition = "VARCHAR(512)", unique = true)
    @NotNull
    private String id;

    @NotNull
    private String street;

    @Column(name="street_number", columnDefinition = "int2")
    @NotNull
    private int streetNumber;

    @Column(name="floorNumber", columnDefinition = "int2")
    private Integer floorNumber;

    @Column(name="apartment_number", columnDefinition = "int2")
    private Integer apartmentNumber;

}
