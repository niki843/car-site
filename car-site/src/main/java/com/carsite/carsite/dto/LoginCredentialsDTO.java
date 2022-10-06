package com.carsite.carsite.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class LoginCredentialsDTO {

    public LoginCredentialsDTO (){

    }

    public LoginCredentialsDTO (String username, String password) {
        this.username = username;
        this.password = password;
    }

    @NotNull
    @ApiModelProperty(value = "The username of the user trying to log in", example = "testuser")
    private String username;

    @NotNull
    @ApiModelProperty(value = "Users password in a non hashed state", example = "123456")
    private String password;
}
