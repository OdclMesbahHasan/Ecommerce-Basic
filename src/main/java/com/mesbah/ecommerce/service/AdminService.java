package com.mesbah.ecommerce.service;

import com.mesbah.ecommerce.entity.Admin;
import com.mesbah.ecommerce.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin with id " + id + " not found"));
    }

    public void createUser(Admin admin) {
        adminRepository.save(admin);
    }

    public void updateAdmin(Admin admin) {
        adminRepository.findById(admin.getId()).orElseThrow(() -> new RuntimeException("Admin with id " + admin.getId() + " not found"));
        adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin with id " + id + " not found"));
        adminRepository.deleteById(id);
    }

    public boolean verifyCredentials(String email, String password) {
    	Admin admin = adminRepository.findByEmail(email);
    	if(admin.getPassword().equals(password)) {
    		return true;
    	}
    	return false;
    }
}
