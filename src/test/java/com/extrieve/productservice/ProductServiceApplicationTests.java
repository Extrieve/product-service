package com.extrieve.productservice;

import com.extrieve.productservice.dto.ProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

	private final MockMvc mockMvc;

	private final ObjectMapper objectMapper;

	ProductServiceApplicationTests(MockMvc mockMvc, ObjectMapper objectMapper) {
		this.mockMvc = mockMvc;
		this.objectMapper = objectMapper;
	}

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}
	@Test
	void ensureProductCreation() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(getProductRequest()))
				).andExpect(status().isCreated());
	}

	private ProductRequest getProductRequest(){
		return ProductRequest.builder()
				.name("Test Product")
				.description("Test Description")
				.price("100")
				.build();
	}

}
