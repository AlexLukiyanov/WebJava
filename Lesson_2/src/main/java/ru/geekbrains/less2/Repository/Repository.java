package ru.geekbrains.less2.Repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.less2.Module.Product;

@Component
public interface Repository {
    Product findById(Long id);

    Product findByName(String name);

}
