package com.carsite.carsite.service;

import com.carsite.carsite.dto.LoginCredentialsDTO;
import com.carsite.carsite.dto.UserDTO;
import com.carsite.carsite.mapper.UserMapper;
import com.carsite.carsite.model.User;
import com.carsite.carsite.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    private final UserMapper userMapper;
    private AuthenticationService authenticationService;

    public UserService (
            UserRepository userRepository,
            UserMapper userMapper,
            AuthenticationService authenticationService
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.authenticationService = authenticationService;
    }


    public UserDTO updateUser(UserDTO userDTO) {
        LoginCredentialsDTO loginCredentialsDTO = new LoginCredentialsDTO(userDTO.getUsername(), userDTO.getPassword());
        authenticationService.getLogin(loginCredentialsDTO);

        User user = userMapper.userDTOToUpdatedUser(userDTO);
        userRepository.save(user);

        user = userRepository.getById(user.getId());

        return userMapper.toUserDTO(user);
    }
}
