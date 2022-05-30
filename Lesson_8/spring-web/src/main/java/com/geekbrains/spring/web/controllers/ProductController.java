package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.data.Product;
import com.geekbrains.spring.web.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllStudents() {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public ResponseEntity<?> addStudent(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/products/change_amount")
    public void changeAmount(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeAmount(productId, delta);
    }

    @GetMapping("/products/filter")
    public List<Product> filterProduct(@RequestParam Integer min, @RequestParam Integer max) {
        return productService.findRangeProduct(min, max);
    }

}
