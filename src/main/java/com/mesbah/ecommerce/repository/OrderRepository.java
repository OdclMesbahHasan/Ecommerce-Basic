package com.mesbah.ecommerce.repository;

import com.mesbah.ecommerce.entity.Order;
import com.mesbah.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findByUser(User user);
}
