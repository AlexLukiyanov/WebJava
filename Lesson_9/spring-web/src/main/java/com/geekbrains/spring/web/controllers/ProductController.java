package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.data.Product;
import com.geekbrains.spring.web.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public Page<Product> getAllProducts(@RequestParam(name = "p", defaultValue = "1") Integer page,
                                        @RequestParam(name = "min_score", required = false) Integer minScore,
                                        @RequestParam(name = "max_score", required = false) Integer maxScore,
                                        @RequestParam(name = "name_part", required = false) String partName
    ) {
        if(page < 1){
            page = 1;
        }
        return productService.findAllProduct(page, maxScore, minScore, partName);
    }

    @PostMapping()
    public ResponseEntity<?> addStudent(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping
    public void changeAmount(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeAmount(productId, delta);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }

    @GetMapping("/filter")
    public List<Product> filterProduct(@RequestParam Integer min, @RequestParam Integer max) {
        return productService.findRangeProduct(min, max);
    }

}
