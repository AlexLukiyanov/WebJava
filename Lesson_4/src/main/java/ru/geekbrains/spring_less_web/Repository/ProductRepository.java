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
                new Product(1L, "Apelsin", 1),
                new Product (2L, "Banan",1),
                new Product(3L, "Crupa", 1),
                new Product(4L, "Macaroni", 1),
                new Product(5L, "Vine", 1),
                new Product(6L, "Apple", 1),
                new Product(7L, "Vinograd", 1),
                new Product(8L, "Sir", 1),
                new Product(9L, "Safar", 1),
                new Product(10L, "Tea", 1)
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

    public void deleteProduct(Long id) {
        productList.removeIf(c -> c.getId().equals(id));
    }

}
