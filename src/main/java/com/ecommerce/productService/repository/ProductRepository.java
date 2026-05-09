package com.ecommerce.productService.repository;

import com.ecommerce.productService.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
