package com.example.programmingexercise.product;

import com.example.programmingexercise.products.Product;
import com.example.programmingexercise.products.ProductController;
import com.example.programmingexercise.products.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    ProductService productServiceMock = Mockito.mock(ProductService.class);
    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private ProductController productController;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllProducts() throws Exception {
        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk());
    }

    @Test
    public void createProduct() throws Exception {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setPrice(5.0);
        product1.setName("Test Product");
        String productJson = objectMapper.writeValueAsString(product1);
        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productJson))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    public void deleteProduct() throws Exception {
        Mockito.when(productServiceMock.deleteProduct(10L)).thenReturn(true);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        mockMvc.perform(delete("/api/products/{id}", 10)).andExpect(status().is2xxSuccessful());
    }
}
