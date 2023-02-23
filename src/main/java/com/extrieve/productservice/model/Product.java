package com.extrieve.productservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
//    private String category;
    private String price;

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }
}
