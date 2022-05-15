package ru.geekbrains.spring_less_web.ProductDAOPac;


import org.springframework.context.annotation.Bean;
import ru.geekbrains.spring_less_web.Model.Product;

import java.util.List;

public interface ProductDAO {

    Product findById (Long id);

    void findClientByProductId (Long id);

    List<Product> findAll();

    void deleteById(Long id);

    Product saveOrUpdate(Product product);
}
