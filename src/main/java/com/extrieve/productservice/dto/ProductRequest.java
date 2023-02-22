package com.extrieve.productservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductRequest {
    private String name;
    private String description;
    private String price;
}
