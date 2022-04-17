package ru.geekbrains.spring_less_web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring_less_web.Model.Basket;
import ru.geekbrains.spring_less_web.Model.Product;
import ru.geekbrains.spring_less_web.Repository.BasketRepository;

import java.util.List;

@Component
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    public void addBasket(List<Product> product, Long id) {
        basketRepository.addProductBasket(product, id);
    }

    public void delBasket(List<Product> product, Long id) {
        basketRepository.removeProductBasket(product, id);
    }

    public List<Product> checkBasketProduct() {
        return basketRepository.getAllBasket();
    }
}
