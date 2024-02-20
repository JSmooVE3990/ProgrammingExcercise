package com.example.programmingexercise.orderitem;

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
public class OrderItemControllerIntegrationTest {

    OrderItemService orderItemServiceMock = Mockito.mock(OrderItemService.class);
    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private OrderItemController orderItemController;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllOrderItems() throws Exception {
        mockMvc.perform(get("/api/orderitems"))
                .andExpect(status().isOk());
    }

    @Test
    public void createOrderItem() throws Exception {
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setId(1L);
        String orderItemJson = objectMapper.writeValueAsString(orderItem1);
        mockMvc.perform(post("/api/orderitems")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderItemJson))
                .andExpect(status().isCreated()) // Expect HTTP 201 Created status
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists()); // Expect the response to contain the ID of the created product
    }

    @Test
    public void deleteOrder() throws Exception {
        Mockito.when(orderItemServiceMock.deleteOrderItem(10L)).thenReturn(true);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(orderItemController).build();
        mockMvc.perform(delete("/api/orderitems/{id}", 10)).andExpect(status().is2xxSuccessful());
    }
}
