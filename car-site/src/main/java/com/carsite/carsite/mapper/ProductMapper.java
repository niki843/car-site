package com.carsite.carsite.mapper;

import com.carsite.carsite.dto.ProductDTO;
import com.carsite.carsite.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    @Mappings({
            @Mapping(target = "id", source = "product.id"),
            @Mapping(target = "description", source = "product.description"),
            @Mapping(target = "availableCount", source = "product.availableCount"),
            @Mapping(target = "discount", source = "product.discount"),
            @Mapping(target = "price", source = "product.price")
    })
    ProductDTO toProductDTO(Product product);

}
