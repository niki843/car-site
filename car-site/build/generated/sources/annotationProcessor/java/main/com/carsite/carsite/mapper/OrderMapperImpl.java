package com.carsite.carsite.mapper;

import com.carsite.carsite.dto.OrderDTO;
import com.carsite.carsite.model.Order;
import com.carsite.carsite.model.OrderGroup;
import com.carsite.carsite.model.Product;
import com.carsite.carsite.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-17T14:50:37+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.0.2.jar, environment: Java 11.0.4 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO toOrderDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId( order.getId() );
        orderDTO.setUserId( orderUserId( order ) );
        orderDTO.setProductId( orderProductId( order ) );
        orderDTO.setProductCount( order.getProductCount() );
        orderDTO.setOrderGroupId( orderOrderGroupId( order ) );

        return orderDTO;
    }

    @Override
    public Order orderDTOtoOrder(OrderDTO order, Product product, OrderGroup orderGroup, User user) {
        if ( order == null && product == null && orderGroup == null && user == null ) {
            return null;
        }

        Order order1 = new Order();

        if ( order != null ) {
            order1.setId( order.getId() );
            order1.setProductCount( order.getProductCount() );
        }
        if ( product != null ) {
            order1.setProduct( product );
        }
        if ( orderGroup != null ) {
            order1.setOrderGroup( orderGroup );
        }
        if ( user != null ) {
            order1.setUser( user );
        }

        return order1;
    }

    private String orderUserId(Order order) {
        if ( order == null ) {
            return null;
        }
        User user = order.getUser();
        if ( user == null ) {
            return null;
        }
        String id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String orderProductId(Order order) {
        if ( order == null ) {
            return null;
        }
        Product product = order.getProduct();
        if ( product == null ) {
            return null;
        }
        String id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String orderOrderGroupId(Order order) {
        if ( order == null ) {
            return null;
        }
        OrderGroup orderGroup = order.getOrderGroup();
        if ( orderGroup == null ) {
            return null;
        }
        String id = orderGroup.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
