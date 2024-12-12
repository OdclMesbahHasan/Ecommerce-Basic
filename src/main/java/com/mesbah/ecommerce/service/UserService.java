package com.mesbah.ecommerce.service;

import com.mesbah.ecommerce.entity.User;
import com.mesbah.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User User) {
        userRepository.findById(User.getId()).orElseThrow(() -> new RuntimeException("User with id " + User.getId() + " not found"));
        userRepository.save(User);
    }

    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        userRepository.deleteById(id);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean verifyCredentials(String email, String password) {
        User User = userRepository.findByEmail(email);
        if (User.getPassword().equals(password)) {
            return true;
        }

        return false;
    }

}
