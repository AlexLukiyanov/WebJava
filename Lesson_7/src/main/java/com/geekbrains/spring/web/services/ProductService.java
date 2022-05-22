package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.data.Product;
import com.geekbrains.spring.web.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void addProduct(String title, Integer price) {
        productRepository.addProduct(title, price);
    }

    public Optional<Product> findMinPriceProduct(Integer min) {
        return productRepository.findProductMinPrice(min);
    }

    public Optional<Product> findMaxPriceProduct(Integer max) {
        return productRepository.findProductMaxPrice(max);
    }

    public Optional<Product> findRangeProduct(Integer min, Integer max) {
        return productRepository.findRangeProduct(min, max);
    }
}
