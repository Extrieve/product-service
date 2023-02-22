package com.extrieve.productservice.repository;

import com.extrieve.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product, String> {

}
