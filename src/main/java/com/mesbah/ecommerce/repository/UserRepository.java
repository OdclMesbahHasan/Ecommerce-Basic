package com.mesbah.ecommerce.repository;

import com.mesbah.ecommerce.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);

    @Transactional
    @Query(value = "SELECT setval(users_id_seq, (SELECT MAX(id) FROM users))", nativeQuery = true)
    void resetUserSequence();
}
