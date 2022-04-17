package ru.geekbrains.spring_less_web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geekbrains.spring_less_web.Model.Client;
import ru.geekbrains.spring_less_web.Repository.ClientRepository;
import ru.geekbrains.spring_less_web.Service.ClientService;
import ru.geekbrains.spring_less_web.Service.ProductService;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/client/{id}")
    public String getTest(Model model, @PathVariable Long id){
        Client client = clientService.fiendClientsForId(id);
        model.addAttribute("man", client);
        return "client_page";
    }

    @GetMapping("/client/all")
    public String getTest(Model model){
        model.addAttribute("men", clientService.allClients());
        return "clients_info_page";
    }

    //http://localhost/app/add
    @GetMapping("/add")
    @ResponseBody
    public String add(){
        return "hello";
    }

    //http://localhost/app/sum?param=1&param1=2
    @GetMapping("/sum")
    @ResponseBody
    public int sum(@RequestParam(name = "param") int a, @RequestParam(name = "param1") int b){
        return a + b;
    }

    //http://localhost/app/client/2/info
    @GetMapping("/client/{id}/info")
    @ResponseBody
    public String findClientById(@PathVariable Long id){
        return "Client # " + id;
    }
}
