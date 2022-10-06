package com.carsite.carsite.mapper;

import com.carsite.carsite.dto.AddressDTO;
import com.carsite.carsite.model.Address;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T14:50:37+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.0.2.jar, environment: Java 11.0.4 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDTO toAddressDTO(Address address) {
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

    @Override
    public Address addressDtoToAddress(AddressDTO address) {
        if ( address == null ) {
            return null;
        }

        Address address1 = new Address();

        address1.setId( address.getId() );
        address1.setStreet( address.getStreet() );
        address1.setStreetNumber( address.getStreetNumber() );
        address1.setFloorNumber( address.getFloorNumber() );
        address1.setApartmentNumber( address.getApartmentNumber() );

        return address1;
    }
}
