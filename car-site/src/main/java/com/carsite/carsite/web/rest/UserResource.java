package com.carsite.carsite.web.rest;

import com.carsite.carsite.dto.UserDTO;
import com.carsite.carsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserResource {

    @Autowired
    private final UserService userService;

    UserResource(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("permitAll()")
    @PutMapping("/update-user")
    public UserDTO updateUser(@Valid @RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }


}
