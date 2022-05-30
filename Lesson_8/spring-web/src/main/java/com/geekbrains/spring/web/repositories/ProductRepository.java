package com.geekbrains.spring.web.repositories;

import com.geekbrains.spring.web.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByAmountBetween(Integer min, Integer max);

    @Query("select p from Product p where p.amount < 80")
    List<Product> findLowAmountProduct();

    @Query("select p from Product p where p.name = :name")
    Optional<Product> findProductByName(String name);

    boolean existsProductByName(String name);

    @Query("select p from Product p where p.amount > :min and p.amount < :max")
    List<Product> findRangeProduct(Integer min, Integer max);
}
