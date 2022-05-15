package ru.geekbrains.spring_less_web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_less_web.ClientDAOPac.ClientDAOImpl;
import ru.geekbrains.spring_less_web.Model.Client;
import ru.geekbrains.spring_less_web.Model.Product;
import ru.geekbrains.spring_less_web.ProductDAOPac.ProductDAOImpl;
import ru.geekbrains.spring_less_web.Service.ClientService;
import ru.geekbrains.spring_less_web.Service.ProductService;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ClientService service;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDAOImpl productDAO;

    @Autowired
    private ClientDAOImpl clientDAO;


    @GetMapping("/client/all")
    public List<Client> getTest(){
        return clientDAO.findAll();
    }

    @GetMapping("/client/findid")
    public void fiendProductbyId(@RequestParam Long id) {
        clientDAO.findProductByClientId(id);
    }

    @GetMapping("/client/change_score")
    public void changeScore(@RequestParam Long clientId, @RequestParam Integer delta){
        service.changeScore(clientId, delta);
    }

    @PostMapping("/client/add")
    public void addClientPost(@RequestBody Client client){
        //clientDAO.
        //clientDAO..addClient(client);
    }

    @GetMapping("/product/all")
    public List<Product> getProduct() {
        return productDAO.findAll();
    }

    @GetMapping("/product/change_score_product")
    public void changeScoreProduct(@RequestParam Long id, @RequestParam Integer amount){
        productService.changeScoreProduct(id, amount);
    }

    @GetMapping("/product/delete")
    public void deleteProduct(@RequestParam Long id) {
        productDAO.deleteById(id);
    }
}
