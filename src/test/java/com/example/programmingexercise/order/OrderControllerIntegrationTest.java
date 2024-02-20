package com.example.programmingexercise.order;

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
public class OrderControllerIntegrationTest {
    OrderService orderServiceMock = Mockito.mock(OrderService.class);
    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private OrderController orderController;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllOrders() throws Exception {
        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk());
    }

    @Test
    public void createOrder() throws Exception {
        Order order1 = new Order();
        order1.setId(1L);

        String orderJson = objectMapper.writeValueAsString(order1);
        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderJson))
                .andExpect(status().isCreated()) // Expect HTTP 201 Created status
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists()); // Expect the response to contain the ID of the created product
    }

    @Test
    public void deleteOrder() throws Exception {
        Mockito.when(orderServiceMock.deleteOrder(10L)).thenReturn(true);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
        mockMvc.perform(delete("/api/orders/{id}", 10)).andExpect(status().is2xxSuccessful());
    }
}
