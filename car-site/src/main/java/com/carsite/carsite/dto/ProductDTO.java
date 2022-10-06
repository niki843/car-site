package com.carsite.carsite.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductDTO {

    @NotNull
    @ApiModelProperty(notes = "The id for the product", example = "b535130c-e68e-4aab-81b3-2bf157e3822e")
    private String id;

    @NotNull
    @ApiModelProperty(notes = "The description for the product", example = "A exhaust pipe for mazda 6 2002-2006")
    private String description;

    @ApiModelProperty(notes = "The amount of available products", example = "20")
    private int availableCount;

    @ApiModelProperty(notes = "Discount for the product if there is any", example = "0,1")
    private Double discount;

    @NotNull
    @ApiModelProperty(notes = "The price for the product", example = "10.99")
    private Double price;

}
