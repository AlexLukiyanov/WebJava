package ru.geekbrains.less2.Repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.geekbrains.less2.Module.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Primary
public class ProductInMemoryRepository implements Repository {

    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product("Milk", 1L, 10),
                new Product("Bread", 2L, 15),
                new Product("Apple", 3L, 20),
                new Product("Orange", 4L, 2),
                new Product("Mango", 5L, 30)
        ));
    }

    @Override
    public Product findById(Long id) {
        return productList.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }

    @Override
    public Product findByName(String name) {
        return productList.stream().filter(p -> p.getTitle().equals(name)).findFirst().orElseThrow(RuntimeException::new);
    }

}
