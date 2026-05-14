package com.ecommerce.productservice.controller;

import com.ecommerce.productservice.dto.ProductRequestDTO;
import com.ecommerce.productservice.dto.ProductResponseDTO;
import com.ecommerce.productservice.entity.Product;
import com.ecommerce.productservice.mapper.ProductMapper;
import com.ecommerce.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/products")
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
    
    @GetMapping("/{id}")
    public String getProduct(@PathVariable Long id) {
        log.debug("id : {}", id);
        return "Product " + id;
    }
}
