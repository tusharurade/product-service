package com.ecommerce.productservice.controller;

import com.ecommerce.productservice.dto.ProductRequestDTO;
import com.ecommerce.productservice.dto.ProductResponseDTO;
import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.mapper.ProductMapper;
import com.ecommerce.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductControlller {
    @Autowired
    private final ProductService prodService;
    @PostMapping
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductRequestDTO request) {
        var product = prodService.createProduct(request);
        return ProductMapper.toDTO(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return prodService.getAllProducts();
    }
}
