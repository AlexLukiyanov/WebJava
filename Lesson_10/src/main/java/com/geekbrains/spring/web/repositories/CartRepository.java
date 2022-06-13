package com.geekbrains.spring.web.repositories;

import com.geekbrains.spring.web.entities.Cart;

import com.geekbrains.spring.web.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long>, JpaSpecificationExecutor<Cart> {

}
