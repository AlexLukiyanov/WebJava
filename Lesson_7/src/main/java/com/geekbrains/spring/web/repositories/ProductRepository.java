package com.geekbrains.spring.web.repositories;

import com.geekbrains.spring.web.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p")
    List<Product> findAll();

    @Query("select p from Product p where p.id = :id")
    Optional<Product> findById(Long id);

    @Query("delete from Product p where p.id = :id")
    void deleteById(Long id);

    @Query("update Product p set p.title = :title, p.price = :price")
    void addProduct (String title, Integer price);

    @Query("select p from Product p where p.price > :min")
    Optional<Product> findProductMinPrice(Integer min);

    @Query("select p from Product p where p.price < :max")
    Optional<Product> findProductMaxPrice(Integer max);

    @Query("select p from Product p where p.price > :min and p.price < :max")
    Optional<Product> findRangeProduct(Integer min, Integer max);
}
