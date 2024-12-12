package com.mesbah.ecommerce.repository;

import com.mesbah.ecommerce.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Message, Long> {
}
