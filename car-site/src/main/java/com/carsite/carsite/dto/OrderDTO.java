package com.carsite.carsite.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class OrderDTO {

    private static final long serialVersionUID = -1275946524754953643L;

    @NotNull
    @ApiModelProperty(notes = "The id of the order", example = "b535130c-e68e-4aab-81b3-2bf157e3822e")
    private String id;

    @NotNull
    @ApiModelProperty(notes = "The user id that made the order", example = "b535130c-e68e-4aab-81b3-2bf157e3822e")
    private String userId;

    @NotNull
    @ApiModelProperty(value = "The prduct id that the user made for the order", example = "b535130c-e68e-4aab-81b3-2bf157e3822e")
    private String productId;

    @NotNull
    @ApiModelProperty(value = "The count of the products that were orderd for the specific order", example = "10")
    private int productCount;

    @NotNull
    @ApiModelProperty(value = "The order group that this order belongs to", example = "b535130c-e68e-4aab-81b3-2bf157e3822e")
    private String orderGroupId;

}
