package com.extrieve.productservice.dto;

import lombok.*;

/*
    This is the DTO class for the ProductResponse object.
    This class is used to send the response to the client.

    This is considered a good practice to use DTO classes to send the response to the client.
    Since we don't want to expose the internal structure of the object to the client.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductResponse {

    private String id;
    private String name;
    private String description;
    private String price;
}
