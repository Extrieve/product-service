package com.extrieve.productservice.service;

import com.extrieve.productservice.dto.ProductRequest;
import com.extrieve.productservice.model.Product;
import com.extrieve.productservice.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

    productRepo.save(product);
    log.info("Product created: {}", product);
    }

}
