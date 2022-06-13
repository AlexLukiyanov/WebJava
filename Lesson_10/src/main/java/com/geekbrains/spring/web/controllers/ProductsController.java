package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.converters.CartMapper;
import com.geekbrains.spring.web.converters.ProductConverter;
import com.geekbrains.spring.web.converters.ProductMapper;
import com.geekbrains.spring.web.dto.CartDto;
import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.entities.Cart;
import com.geekbrains.spring.web.entities.Product;
import com.geekbrains.spring.web.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.web.services.CartService;
import com.geekbrains.spring.web.services.ProductsService;
import com.geekbrains.spring.web.validators.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

    private final ProductMapper productMapper;
    private final CartService cartService;
    private final CartMapper cartMapper;

    @GetMapping
    public Page<ProductDto> getAllProducts(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minPrice,
            @RequestParam(name = "max_price", required = false) Integer maxPrice,
            @RequestParam(name = "title_part", required = false) String titlePart
    ) {
        if (page < 1) {
            page = 1;
        }
        return productsService.findAll(minPrice, maxPrice, titlePart, page).map(
                p -> productMapper.productDto(p)
        );
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        Product product = productsService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        return productMapper.productDto(product);
    }

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productMapper.toProduct(productDto);
        product = productsService.save(product);
        return productMapper.productDto(product);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productsService.update(productDto);
        return productMapper.productDto(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productsService.deleteById(id);
    }

    @GetMapping("/cartProducts")
    public Page<CartDto> findAllCart(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minPrice,
            @RequestParam(name = "max_price", required = false) Integer maxPrice,
            @RequestParam(name = "title_part", required = false) String titlePart
            ) {
            if (page < 1) {
                page = 1;
            }
            return cartService.findAll(minPrice, maxPrice, titlePart, page).map(
                    pc -> cartMapper.cartDto(pc)
            );
    }

    @DeleteMapping("cartProducts/{id}")
    public void deleteCarttoId(@PathVariable Long id) {
        cartService.deleteProductToCartById(id);
    }

    @PostMapping()
    public CartDto addProductToCartById(@RequestBody ProductDto productDto) {
        Cart cart = cartService.addProductToCart(productDto);
        cart = cartService.saveCart(cart);
        return cartMapper.cartDto(cart);
    }
}
