package ru.geekbrains.spring_less_web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geekbrains.spring_less_web.Model.Client;
import ru.geekbrains.spring_less_web.Model.Product;
import ru.geekbrains.spring_less_web.Service.BasketService;

import java.util.List;

@Controller
public class BasketController {

    @Autowired
    public BasketService basketService;

    // http://localhost:8189/app/basketadd
    @GetMapping("/basketadd")
    public String addBasketProduct(@PathVariable List<Product> product, Long id) {
        basketService.addBasket(product, id);
        return "basket_status_add_page";
    }

    // http://localhost:8189/app/basketdel
    @GetMapping("/basketdel")
    public String delBasketProduct(@PathVariable List<Product> product, Long id) {
        basketService.delBasket(product, id);
        return "check_basket_page";
    }

    // http://localhost:8189/app/basketall
    @GetMapping("/basketall")
    public String delBasketProduct(Model model) {
        model.addAttribute("basall", basketService.checkBasketProduct());
        return "basket_products_info_page";
    }

}
