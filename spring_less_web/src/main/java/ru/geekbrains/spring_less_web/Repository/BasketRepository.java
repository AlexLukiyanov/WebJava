package ru.geekbrains.spring_less_web.Repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring_less_web.Model.Basket;
import ru.geekbrains.spring_less_web.Model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BasketRepository {

    private List<Product> listBasket;

    @PostConstruct
    public void init() {
        listBasket = new ArrayList<>();
    }

    public void addProductBasket(List<Product> product, Long id) {
        int idd = Math.toIntExact(id);
        listBasket.add(product.get(idd));
    }

    public void removeProductBasket(List <Product> product, Long id) {
        int idd = Math.toIntExact(id);
        listBasket.remove(product.remove(idd));
    }

    public List<Product> getAllBasket() {
        return Collections.unmodifiableList(listBasket);
    }

}
