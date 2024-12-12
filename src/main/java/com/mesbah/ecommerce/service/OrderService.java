package com.mesbah.ecommerce.service;

import com.mesbah.ecommerce.entity.Order;
import com.mesbah.ecommerce.entity.User;
import com.mesbah.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order with id " + id + " not found"));
    }

    public void createOrder(Order Order) {
        orderRepository.save(Order);
    }

    public void updateOrder(Order Order) {
        orderRepository.findById(Order.getId()).orElseThrow(() -> new RuntimeException("Order with id " + Order.getId() + " not found"));
        orderRepository.save(Order);
    }

    public void deleteOrder(Long id) {
        orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order with id " + id + " not found"));
        orderRepository.deleteById(id);
    }

    public List<Order> findOrdersByUser(User user) {
        return orderRepository.findByUser(user);
    }
}
