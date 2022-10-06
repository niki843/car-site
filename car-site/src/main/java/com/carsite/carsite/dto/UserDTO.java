package com.carsite.carsite.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserDTO {

    @NotNull
    @ApiModelProperty(notes = "The id of the user", example = "b535130c-e68e-4aab-81b3-2bf157e3822e")
    private String id;

    @NotNull
    @ApiModelProperty(notes = "Username of the user", example = "user1")
    private String username;

    @NotNull
    @ApiModelProperty(notes = "Users password", example = "Password")
    private String password;

    @NotNull
    @ApiModelProperty(notes = "The id of the address of the user")
    private AddressDTO address;

    @NotNull
    @ApiModelProperty(notes = "The email address of the user")
    private String email;

    @ApiModelProperty(notes = "Indicates if the user is an admin", example = "false")
    private Boolean isAdmin;
}
