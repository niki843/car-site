package com.carsite.carsite.web.rest;

import com.carsite.carsite.dto.LoginCredentialsDTO;
import com.carsite.carsite.dto.UserDTO;
import com.carsite.carsite.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationResource {

    @Autowired
    AuthenticationService authenticationService;

    AuthenticationResource (AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/log-in")
    public String getOrder(@Valid @RequestBody LoginCredentialsDTO loginCredentialsDTO) {
        return authenticationService.getLogin(loginCredentialsDTO);
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/register")
    public UserDTO registerUser(@Valid @RequestBody UserDTO userDTO) {
        return authenticationService.createUser(userDTO);
    }
}
