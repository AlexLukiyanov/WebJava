package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.data.Product;
import com.geekbrains.spring.web.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/id")
    public Optional<Product> getProductsById(@RequestParam Long id) {
        return productService.findProductById(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAllProduct();
    }

    @PostMapping("/products")
    public void createProduct(@RequestParam String title, @RequestParam int price) {
        productService.addProduct(title, price);
    }

    @GetMapping("/products/delete/id")
    public void deleteProduct(@RequestParam Long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/products/min")
    public void findMinProduct(@RequestParam(defaultValue = "0") Integer min) {
        productService.findMinPriceProduct(min);
    }

    @GetMapping("/products/max")
    public void findMaxProduct(@RequestParam(defaultValue = "200") Integer max) {
        productService.findMaxPriceProduct(max);
    }

    @GetMapping("/products/minmax")
    public void findMinMaxProduct(@RequestParam(defaultValue = "0") Integer min, @RequestParam(defaultValue = "200") Integer max) {
        productService.findRangeProduct(min, max);
    }
}
