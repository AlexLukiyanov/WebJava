package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.data.Product;
import com.geekbrains.spring.web.exceptions.AppError;
import com.geekbrains.spring.web.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findByScore(Integer min, Integer max) {
        return productRepository.findAllByAmountBetween(min, max);
    }

    @Transactional
    public void changeAmount(Long productId, Integer delta) {
        Product product = productRepository.findById(productId).orElseThrow();
        product.setAmount(product.getAmount() + delta);
        //studentRepository.save(student);
    }

    //public List<Product> findByAmountBetween(Integer min, Integer max) {
    //    return findByAmountBetween(min, max);
    //}

    public ResponseEntity<?> addProduct(Product product) {
        if(productRepository.existsProductByName(product.getName())){
            return new ResponseEntity<>(new AppError(HttpStatus.CONFLICT.value(), "Product is already"), HttpStatus.CONFLICT);
        } else {
            productRepository.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    public List<Product> findRangeProduct(Integer min, Integer max) {
        return productRepository.findRangeProduct(min, max);

    }
}
