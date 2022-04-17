package ru.geekbrains.spring_less_web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring_less_web.Model.Client;
import ru.geekbrains.spring_less_web.Model.Product;
import ru.geekbrains.spring_less_web.Repository.ClientRepository;
import ru.geekbrains.spring_less_web.Repository.ProductRepository;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> allProduct() {
        return productRepository.getAllProduct();
    }

    public Product ProductFindId(Long id) {
        return productRepository.findById(id);
    }
}
