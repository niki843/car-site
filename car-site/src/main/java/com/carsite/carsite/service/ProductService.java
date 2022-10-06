package com.carsite.carsite.service;

import com.carsite.carsite.dto.ProductDTO;
import com.carsite.carsite.exception.NotFoundException;
import com.carsite.carsite.mapper.ProductMapper;
import com.carsite.carsite.model.Product;
import com.carsite.carsite.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDTO getProductById(String productId) {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new NotFoundException("No such product with that id!"));
        return productMapper.toProductDTO(product);
    }

}
