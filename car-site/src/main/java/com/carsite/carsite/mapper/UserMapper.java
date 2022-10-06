package com.carsite.carsite.mapper;

import com.carsite.carsite.dto.UserDTO;
import com.carsite.carsite.model.Address;
import com.carsite.carsite.model.User;
import org.mapstruct.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mappings({
            @Mapping(target = "id", source = "user.id"),
            @Mapping(target = "username", source = "user.username"),
            @Mapping(target = "password", source = "user.passwordHash"),
            @Mapping(target = "address", source = "user.address"),
            @Mapping(target = "isAdmin", source = "user.isAdmin")
    })
    UserDTO toUserDTO(User user);

    @Mappings({
            @Mapping(target = "id", source = "user.id"),
            @Mapping(target = "username", source = "user.username"),
            @Mapping(target = "passwordHash", source = "user.password", qualifiedByName = "hashPassword"),
            @Mapping(target = "address", source = "address"),
            @Mapping(target = "isAdmin", source = "isAdmin")
    })
    User userDTOToUser(UserDTO user, Address address, boolean isAdmin);

    @Mappings({
            @Mapping(target = "passwordHash", source = "user.password", qualifiedByName = "hashPassword"),
            @Mapping(target = "address", source = "address")
    })
    User userDTOToUpdatedUser(UserDTO user);


    @Named("hashPassword")
    default String hashPassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }
}
