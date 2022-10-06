package com.carsite.carsite.mapper;

import com.carsite.carsite.dto.OrderGroupDTO;
import com.carsite.carsite.model.OrderGroup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderGroupMapper {

    @Mappings({
            @Mapping(target = "id", source = "orderGroup.id"),
            @Mapping(target = "price", source = "orderGroup.groupPrice"),
            @Mapping(target = "productsAmount", source = "orderGroup.productsAmount")
    })
    OrderGroupDTO toOrderGroupDTO(OrderGroup orderGroup);

}
