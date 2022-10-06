package com.carsite.carsite.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddressDTO {

    @NotNull
    @ApiModelProperty(notes = "The id for the address", example = "b535130c-e68e-4aab-81b3-2bf157e3822e")
    private String id;

    @NotNull
    @ApiModelProperty(notes = "The street that the person lives on", example = "test street")
    private String street;

    @NotNull
    @ApiModelProperty(notes = "The number of the street", example = "13")
    private int streetNumber;

    @ApiModelProperty(notes = "The floor if it's an apartment building", example = "10")
    private Integer floorNumber;

    @ApiModelProperty(notes = "The apratment number if it's in a apatment building", example = "33")
    private Integer apartmentNumber;

}
