package ru.geekbrains.less2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.less2.Module.Product;
import ru.geekbrains.less2.Repository.CartInMemoryRepository;
import ru.geekbrains.less2.Repository.Repository;

@Component()
public class ProductService {

    @Autowired
    private Repository repository;
    private CartInMemoryRepository cartInMemoryRepository;

    public Product getProductId(Long id){
       return repository.findById(id);
    }

    public Product getProductName(String name) {
        return repository.findByName(name);
    }

    public void addedToCart(Long id) {
        cartInMemoryRepository.addedToId(id);
    }

    public void deleteToCart(int id) {
        cartInMemoryRepository.deleteToId(id);
    }

}
