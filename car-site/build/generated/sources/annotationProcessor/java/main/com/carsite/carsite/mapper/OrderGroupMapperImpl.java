package com.carsite.carsite.mapper;

import com.carsite.carsite.dto.OrderGroupDTO;
import com.carsite.carsite.model.OrderGroup;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T14:50:37+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.0.2.jar, environment: Java 11.0.4 (Oracle Corporation)"
)
@Component
public class OrderGroupMapperImpl implements OrderGroupMapper {

    @Override
    public OrderGroupDTO toOrderGroupDTO(OrderGroup orderGroup) {
        if ( orderGroup == null ) {
            return null;
        }

        OrderGroupDTO orderGroupDTO = new OrderGroupDTO();

        orderGroupDTO.setId( orderGroup.getId() );
        orderGroupDTO.setPrice( orderGroup.getGroupPrice() );
        orderGroupDTO.setProductsAmount( orderGroup.getProductsAmount() );

        return orderGroupDTO;
    }
}
