package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.dto.CartDto;
import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.entities.Cart;
import com.geekbrains.spring.web.entities.Product;
import com.geekbrains.spring.web.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.web.repositories.CartRepository;
import com.geekbrains.spring.web.repositories.ProductsRepository;
import com.geekbrains.spring.web.repositories.specifications.CartSpecifications;
import com.geekbrains.spring.web.repositories.specifications.ProductsSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartDto cartDto;

    public Page<Cart> findAll(Integer minPrice, Integer maxPrice, String partTitle, Integer page) {
        Specification<Cart> spec = Specification.where(null);
        if (minPrice != null) {
            spec = spec.and(CartSpecifications.priceGreaterOrEqualsThanCart(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(CartSpecifications.priceLessThanOrEqualsThanCart(maxPrice));
        }
        if (partTitle != null) {
            spec = spec.and(CartSpecifications.titleLikeCart(partTitle));
        }

        return cartRepository.findAll(spec, PageRequest.of(page - 1, 50));
    }

    public Cart addProductToCart(ProductDto productDto) {
        Cart cart = cartRepository.findById(cartDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Невозможно обновить продукта, не надйен в базе, id: " + productDto.getId()));
        cartDto.setPrice(productDto.getPrice());
        cartDto.setTitle(productDto.getTitle());
        return cart;
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteProductToCartById(Long id) {
        cartRepository.deleteById(id);
    }

}
