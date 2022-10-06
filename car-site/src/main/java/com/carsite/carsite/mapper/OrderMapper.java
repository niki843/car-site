package com.carsite.carsite.mapper;

import com.carsite.carsite.dto.OrderDTO;
import com.carsite.carsite.model.Order;
import com.carsite.carsite.model.OrderGroup;
import com.carsite.carsite.model.Product;
import com.carsite.carsite.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    @Mappings({
            @Mapping(target = "id", source = "order.id"),
            @Mapping(target = "userId", source = "order.user.id"),
            @Mapping(target = "productId", source = "order.product.id"),
            @Mapping(target = "productCount", source = "order.productCount"),
            @Mapping(target = "orderGroupId", source = "order.orderGroup.id")
    })
    OrderDTO toOrderDTO(Order order);


    @Mappings({
            @Mapping(target = "id", source = "order.id"),
            @Mapping(target = "user", source = "user"),
            @Mapping(target = "product", source = "product"),
            @Mapping(target = "productCount", source = "order.productCount"),
            @Mapping(target = "orderGroup", source = "orderGroup")
    })
    Order orderDTOtoOrder(OrderDTO order, Product product, OrderGroup orderGroup, User user);

}
