package com.example.programmingexercise.orderitem;

import com.example.programmingexercise.products.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderItemControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllOrderItems() throws Exception {
        mockMvc.perform(get("/api/orderItems"))
                .andExpect(status().isOk());
    }

    @Test
    public void createOrderItem() throws Exception {
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setId(1L);
        String orderItemJson = objectMapper.writeValueAsString(orderItem1);
        mockMvc.perform(post("/api/orderItems")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderItemJson))
                .andExpect(status().isCreated()) // Expect HTTP 201 Created status
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists()); // Expect the response to contain the ID of the created product
    }
}
