package com.carsite.carsite.web.rest;

import com.carsite.carsite.dto.ProductDTO;
import com.carsite.carsite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/products")
public class ProductResource {

    @Autowired
    ProductService productService;

    ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/{productId}")
    public ProductDTO getProductById(@NotNull @PathVariable String productId) {
        return productService.getProductById(productId);
    }

}
