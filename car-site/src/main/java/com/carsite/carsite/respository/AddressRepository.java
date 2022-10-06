package com.carsite.carsite.respository;

import com.carsite.carsite.model.Address;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Qualifier("AddressRepository")
public interface AddressRepository extends JpaRepository<Address, String> {

    Optional<Address> findByStreetAndStreetNumberAndFloorNumberAndApartmentNumber(
            @Param("street") String street,
            @Param("streetNumber") int streetNumber,
            @Param("floorNumber") int floorNumber,
            @Param("apartmentNumber") int apartmentNumber
    );
}
