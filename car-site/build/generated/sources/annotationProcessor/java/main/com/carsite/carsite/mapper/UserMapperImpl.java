package com.carsite.carsite.mapper;

import com.carsite.carsite.dto.AddressDTO;
import com.carsite.carsite.dto.UserDTO;
import com.carsite.carsite.model.Address;
import com.carsite.carsite.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T14:50:37+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.0.2.jar, environment: Java 11.0.4 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setPassword( user.getPasswordHash() );
        userDTO.setAddress( addressToAddressDTO( user.getAddress() ) );
        userDTO.setIsAdmin( user.getIsAdmin() );
        userDTO.setEmail( user.getEmail() );

        return userDTO;
    }

    @Override
    public User userDTOToUser(UserDTO user, Address address, boolean isAdmin) {
        if ( user == null && address == null ) {
            return null;
        }

        User user1 = new User();

        if ( user != null ) {
            user1.setId( user.getId() );
            user1.setUsername( user.getUsername() );
            user1.setPasswordHash( hashPassword( user.getPassword() ) );
            user1.setEmail( user.getEmail() );
        }
        if ( address != null ) {
            user1.setAddress( address );
        }
        user1.setIsAdmin( isAdmin );

        return user1;
    }

    @Override
    public User userDTOToUpdatedUser(UserDTO user) {
        if ( user == null ) {
            return null;
        }

        User user1 = new User();

        user1.setPasswordHash( hashPassword( user.getPassword() ) );
        user1.setAddress( addressDTOToAddress( user.getAddress() ) );
        user1.setId( user.getId() );
        user1.setUsername( user.getUsername() );
        user1.setEmail( user.getEmail() );
        user1.setIsAdmin( user.getIsAdmin() );

        return user1;
    }

    protected AddressDTO addressToAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId( address.getId() );
        addressDTO.setStreet( address.getStreet() );
        addressDTO.setStreetNumber( address.getStreetNumber() );
        addressDTO.setFloorNumber( address.getFloorNumber() );
        addressDTO.setApartmentNumber( address.getApartmentNumber() );

        return addressDTO;
    }

    protected Address addressDTOToAddress(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDTO.getId() );
        address.setStreet( addressDTO.getStreet() );
        address.setStreetNumber( addressDTO.getStreetNumber() );
        address.setFloorNumber( addressDTO.getFloorNumber() );
        address.setApartmentNumber( addressDTO.getApartmentNumber() );

        return address;
    }
}
