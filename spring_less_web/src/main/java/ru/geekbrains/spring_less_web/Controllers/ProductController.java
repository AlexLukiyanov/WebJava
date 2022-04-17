package ru.geekbrains.spring_less_web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.geekbrains.spring_less_web.Model.Client;
import ru.geekbrains.spring_less_web.Model.Product;
import ru.geekbrains.spring_less_web.Repository.ProductRepository;
import ru.geekbrains.spring_less_web.Service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // http://localhost:8189/app/product/info
    @GetMapping("/product/info")
    public String productPageAll(Model model) {
        model.addAttribute("prod", productService.allProduct());
        return "products_info_page";
    }
    // http://localhost:8189/app/product/info/{id}
    @GetMapping("/product/info/{id}")
    public String getTest(Model model, @PathVariable Long id){
        Product product = productService.ProductFindId(id);
        model.addAttribute("prodId", product);
        return "product_page";
    }
}
