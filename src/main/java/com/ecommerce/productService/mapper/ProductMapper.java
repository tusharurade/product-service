package com.ecommerce.productService.mapper;

import com.ecommerce.productService.dto.ProductRequestDTO;
import com.ecommerce.productService.dto.ProductResponseDTO;
import com.ecommerce.productService.entity.Product;

import java.math.BigDecimal;

public class ProductMapper {
    public static ProductResponseDTO toDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    public static Product toEntity(ProductRequestDTO dto) {
        return Product.builder()
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .build();
    }
}