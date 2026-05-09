package com.ecommerce.productService.service;

import com.ecommerce.productService.dto.ProductRequestDTO;
import com.ecommerce.productService.entity.Product;
import com.ecommerce.productService.mapper.ProductMapper;
import com.ecommerce.productService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private final ProductRepository productRepo;

    public Product createProduct(ProductRequestDTO request) {
        log.info("Creating product: {}", request.name());
        final var product = ProductMapper.toEntity(request);
        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

}
