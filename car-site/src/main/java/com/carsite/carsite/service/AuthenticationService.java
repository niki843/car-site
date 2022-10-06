package com.carsite.carsite.service;

import com.carsite.carsite.dto.AddressDTO;
import com.carsite.carsite.dto.LoginCredentialsDTO;
import com.carsite.carsite.dto.UserDTO;
import com.carsite.carsite.exception.NotFoundException;
import com.carsite.carsite.exception.UserExistsException;
import com.carsite.carsite.mapper.AddressMapper;
import com.carsite.carsite.mapper.UserMapper;
import com.carsite.carsite.model.Address;
import com.carsite.carsite.model.User;
import com.carsite.carsite.respository.AddressRepository;
import com.carsite.carsite.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationService {

    private static final String UNAUTHORIZED_REQUEST = "Incorrect credentials provided";


    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final AddressRepository addressRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    AddressMapper addressMapper;
    UserMapper userMapper;

    public AuthenticationService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AddressRepository addressRepository,
            AddressMapper addressMapper,
            UserMapper userMapper
    ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true)
    public String getLogin(LoginCredentialsDTO loginCredentialsDTO) {
        User user = userRepository.findByUsername(loginCredentialsDTO.getUsername())
                .orElseThrow(() -> new NotFoundException(UNAUTHORIZED_REQUEST));

        if (! passwordEncoder.matches(loginCredentialsDTO.getPassword(), user.getPasswordHash())) {
            throw new NotFoundException(UNAUTHORIZED_REQUEST);
        }

        return "Authorized";
    }

    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        Optional<User> userByUsername = userRepository.findByUsername(userDTO.getUsername());
        if (userByUsername.isPresent()) {
            throw new UserExistsException("User with that username already exists");
        }

        Optional<User> userByEmail = userRepository.findByEmail(userDTO.getEmail());
        if (userByEmail.isPresent()) {
            throw new UserExistsException("User with that email already exists");
        }

        AddressDTO addressDTO = userDTO.getAddress();
        Optional<Address> optionalAddress = addressRepository
                .findByStreetAndStreetNumberAndFloorNumberAndApartmentNumber(
                        addressDTO.getStreet(),
                        addressDTO.getStreetNumber(),
                        addressDTO.getFloorNumber(),
                        addressDTO.getApartmentNumber()
                );

        addressDTO.setId(UUID.randomUUID().toString());
        Address address = optionalAddress.orElse(addressMapper.addressDtoToAddress(userDTO.getAddress()));
        addressRepository.save(address);

        userDTO.setId(UUID.randomUUID().toString());
        User user = userMapper.userDTOToUser(userDTO, address, false);
        userRepository.save(user);

        return userDTO;
    }
}
