package com.example.programmingexercise.orderitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository){
        this.orderItemRepository = orderItemRepository;
    }
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.getReferenceById(id);
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public Optional<OrderItem> updateOrderItem(Long id, OrderItem newOrderItemData) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(id);

        if (orderItemOptional.isPresent()) {
            OrderItem existingOrderItem = orderItemOptional.get();;
            OrderItem updatedOrderItem = orderItemRepository.save(existingOrderItem);
            return Optional.of(updatedOrderItem);
        } else {
            return Optional.empty(); // OrderItem with the given ID not found
        }
    }

    public boolean deleteOrderItem(Long id) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(id);

        if (orderItemOptional.isPresent()) {
            orderItemRepository.deleteById(id);
            return true; // Deletion successful
        } else {
            return false; // OrderItem with the given ID not found
        }
    }
}
