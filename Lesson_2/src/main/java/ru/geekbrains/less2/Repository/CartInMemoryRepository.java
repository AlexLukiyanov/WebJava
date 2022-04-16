package ru.geekbrains.less2.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.less2.Module.Product;
import ru.geekbrains.less2.Service.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Primary
@Scope("prototype")
public class CartInMemoryRepository {

    private List<Product> cartList;
    private ProductService productService;

    @Autowired
    public void setProductService (ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    public void init(){
        cartList = new ArrayList<>();
    }

    public void addedToId(Long id) {
            cartList.add(productService.getProductId(id));
    }

    public void deleteToId(int id) {
        cartList.remove(id);
    }

    public void cartAllProd() {
        for (int i = 0; i <= cartList.size(); i++) {
            System.out.println(cartList.toString());
        }
    }

    public void cartSize() {
        System.out.println(cartList.size());
    }
}
