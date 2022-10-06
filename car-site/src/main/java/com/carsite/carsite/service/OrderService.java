package com.carsite.carsite.service;

import com.carsite.carsite.dto.OrderDTO;
import com.carsite.carsite.dto.OrderGroupDTO;
import com.carsite.carsite.exception.BadRequestException;
import com.carsite.carsite.exception.NotFoundException;
import com.carsite.carsite.mapper.OrderGroupMapper;
import com.carsite.carsite.mapper.OrderMapper;
import com.carsite.carsite.model.Order;
import com.carsite.carsite.model.OrderGroup;
import com.carsite.carsite.model.Product;
import com.carsite.carsite.model.User;
import com.carsite.carsite.respository.OrderGroupRepository;
import com.carsite.carsite.respository.OrderRepository;
import com.carsite.carsite.respository.ProductRepository;
import com.carsite.carsite.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private final OrderGroupRepository orderGroupRepository;
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final UserRepository userRepository;

    private final OrderMapper orderMapper;
    private final OrderGroupMapper orderGroupMapper;

    public OrderService(
            OrderRepository orderRepository,
            OrderMapper orderMapper,
            OrderGroupRepository orderGroupRepository,
            OrderGroupMapper orderGroupMapper,
            ProductRepository productRepository,
            UserRepository userRepository
    ){
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.orderGroupRepository = orderGroupRepository;
        this.orderGroupMapper = orderGroupMapper;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public OrderDTO getOrderById(String orderId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("No such order!"));
        return orderMapper.toOrderDTO(order);
    }

    public OrderGroupDTO getOrderGroupById(String orderGroupId) {
        OrderGroup orderGroup = orderGroupRepository
                .findById(orderGroupId)
                .orElseThrow(() -> new NotFoundException("No such order group!"));
        return orderGroupMapper.toOrderGroupDTO(orderGroup);
    }

    public OrderGroupDTO createOrder(List<OrderDTO> ordersDTO) {
        OrderGroup orderGroup = new OrderGroup();

        Set<User> users = ordersDTO.stream()
                .map(orderDTO -> findUserById(orderDTO.getUserId()))
                .collect(Collectors.toSet());

        makeUserValidations(users);
        makeProductDuplicationValidation(ordersDTO);

        Map<Product, Integer> products = ordersDTO.stream()
                .collect(Collectors.toMap(
                        orderDTO -> findProductById(orderDTO.getProductId()),
                        OrderDTO::getProductCount
                ));

        List<Product> productsList = makeProductCountValidationsAndSetAmounts(products);

        List<Double> productsPrice = ordersDTO.stream()
                .map(orderDTO -> {
                    Product product = findProductById(orderDTO.getProductId());
                    double discount = orderDTO.getProductCount() * product.getPrice() * product.getDiscount();
                    return (orderDTO.getProductCount() * product.getPrice()) - discount;
                })
                .collect(Collectors.toList());

        List<Integer> productsCount = ordersDTO.stream()
                .map(OrderDTO::getProductCount)
                .collect(Collectors.toList());

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double formattedPrice = Double.parseDouble(decimalFormat.format((productsPrice.stream().mapToDouble(Double::doubleValue).sum())));

        orderGroup.setId(UUID.randomUUID().toString());
        orderGroup.setGroupPrice(formattedPrice);
        orderGroup.setProductsAmount(productsCount.stream().mapToInt(Integer::intValue).sum());
        ordersDTO.forEach(order -> order.setOrderGroupId(orderGroup.getId()));

        List<Order> orders = ordersDTO.stream()
                .map(orderDTO -> orderMapper.orderDTOtoOrder(orderDTO, findProductById(orderDTO.getProductId()), orderGroup, users.iterator().next()))
                .collect(Collectors.toList());
        orders.forEach(order -> order.setId(UUID.randomUUID().toString()));

        orderGroupRepository.save(orderGroup);
        orderRepository.saveAll(orders);
        productRepository.saveAll(productsList);

        return orderGroupMapper.toOrderGroupDTO(orderGroup);
    }

    public Product findProductById(String productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Bad product id provided!"));
    }

    public User findUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("The provided userId did not match any of the existing!"));
    }

    private void makeUserValidations(Set<User> users) {
        if (users.size() > 1){
            throw new BadRequestException("Only one userId premited for a oreder group!");
        }
        if (users.size() == 0){
            throw new NotFoundException("No user found with the provided id!");
        }
        users.iterator().next();
    }

    private List<Product> makeProductCountValidationsAndSetAmounts(Map<Product, Integer> products) {
        products.forEach((product, amount) -> {
            if (amount <= 0 ){
                throw new BadRequestException("The amount can not be zero or less!");
            }
            if (product.getAvailableCount() < amount) {
                throw new BadRequestException("Amount larger than the available product!");
            }
        });
        products.forEach((product, amount) -> {
            product.setAvailableCount(product.getAvailableCount() - amount);
        });
        return new ArrayList<>(products.keySet());
    }

    private void  makeProductDuplicationValidation (List<OrderDTO> orderDTOs) {
        Set<String> uniqueProductIds = orderDTOs.stream().map(OrderDTO::getProductId).collect(Collectors.toSet());
        List<String> allProductIds = orderDTOs.stream().map(OrderDTO::getProductId).collect(Collectors.toList());
        if (uniqueProductIds.size() != allProductIds.size()) {
            throw new BadRequestException("There are duplicating products in orders list!");
        }
    }
}
