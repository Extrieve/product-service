package com.extrieve.productservice.service;

import com.extrieve.productservice.dto.ProductRequest;
import com.extrieve.productservice.dto.ProductResponse;
import com.extrieve.productservice.model.Product;
import com.extrieve.productservice.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> products = productRepo.findAll()
                .stream()
                .map(this::mapProductToProductResponse)
                .toList();

        log.info("Products found: {}", products);
        return products;
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

    public ProductResponse mapProductToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}
