package com.carsite.carsite.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OrderGroupDTO {

    @NotNull
    @ApiModelProperty(notes = "The id of the order group", example = "b535130c-e68e-4aab-81b3-2bf157e3822e")
    private String id;

    @NotNull
    @ApiModelProperty(notes = "The full price of the order group", example = "100.99")
    private Double price;

    @NotNull
    @ApiModelProperty(notes = "The ammount of the full group of orders", example = "2")
    private int productsAmount;

}
