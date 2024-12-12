package com.mesbah.ecommerce.service;

import com.mesbah.ecommerce.entity.Product;
import com.mesbah.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));
    }

    public void createProduct(Product Product) {
        productRepository.save(Product);
    }

    public void updateProduct(Product Product) {
        productRepository.findById(Product.getId()).orElseThrow(() -> new RuntimeException("Product with id " + Product.getId() + " not found"));
        productRepository.save(Product);
    }

    public void deleteProduct(Long id) {
        productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));
        productRepository.deleteById(id);
    }

    public Product findProductByName(String name) {
        return productRepository.findByName(name);
    }

}