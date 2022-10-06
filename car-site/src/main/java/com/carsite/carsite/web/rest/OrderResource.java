package com.carsite.carsite.web.rest;

import com.carsite.carsite.dto.OrderDTO;
import com.carsite.carsite.dto.OrderGroupDTO;
import com.carsite.carsite.service.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/orders")
public class OrderResource {

    private final OrderService orderService;

    OrderResource(OrderService orderService){
        this.orderService = orderService;
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/order-group/{orderId}")
    public OrderDTO getOrder(@PathVariable String orderId){
        return orderService.getOrderById(orderId);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/{orderGroupId}")
    public OrderGroupDTO getOrderGroup(@PathVariable String orderGroupId) {
        return orderService.getOrderGroupById(orderGroupId);
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/create-order")
    public OrderGroupDTO createOrder(@Validated @RequestBody List<OrderDTO> orders) {
        return orderService.createOrder(orders);
    }
}
