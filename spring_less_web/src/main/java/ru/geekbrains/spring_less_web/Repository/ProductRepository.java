package ru.geekbrains.spring_less_web.Repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring_less_web.Model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {


    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product(1L, "Apelsin", 10L),
                new Product (2L, "Banan",20L),
                new Product(3L, "Crupa", 30L),
                new Product(4L, "Macaroni", 40L),
                new Product(5L, "Vine", 50L),
                new Product(6L, "Apple", 60L),
                new Product(7L, "Vinograd", 70L),
                new Product(8L, "Sir", 80L),
                new Product(9L, "Safar", 90L),
                new Product(10L, "Tea", 100L)
        ));
    }

    public List<Product> getAllProduct() {
        return Collections.unmodifiableList(productList);
    }

    public Product findById(Long id){
        return productList.stream().filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

}
