package com.carsite.carsite.mapper;

import com.carsite.carsite.dto.AddressDTO;
import com.carsite.carsite.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    @Mappings({
            @Mapping(target = "id", source = "address.id"),
            @Mapping(target = "street", source = "address.street"),
            @Mapping(target = "streetNumber", source = "address.streetNumber"),
            @Mapping(target = "floorNumber", source = "address.floorNumber"),
            @Mapping(target = "apartmentNumber", source = "address.apartmentNumber")
    })
    AddressDTO toAddressDTO(Address address);

    @Mappings({
            @Mapping(target = "id", source = "address.id"),
            @Mapping(target = "street", source = "address.street"),
            @Mapping(target = "streetNumber", source = "address.streetNumber"),
            @Mapping(target = "floorNumber", source = "address.floorNumber"),
            @Mapping(target = "apartmentNumber", source = "address.apartmentNumber")
    })
    Address addressDtoToAddress(AddressDTO address);

}
