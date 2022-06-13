package com.geekbrains.spring.web.repositories.specifications;

import com.geekbrains.spring.web.entities.Cart;
import com.geekbrains.spring.web.entities.Product;
import org.springframework.data.jpa.domain.Specification;

public class CartSpecifications {
    public static Specification<Cart> priceGreaterOrEqualsThanCart(Integer price) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Cart> priceLessThanOrEqualsThanCart(Integer price) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Cart> titleLikeCart(String titlePart) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart));
    }
}
