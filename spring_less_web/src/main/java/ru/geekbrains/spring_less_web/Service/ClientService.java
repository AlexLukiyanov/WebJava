package ru.geekbrains.spring_less_web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring_less_web.Model.Client;
import ru.geekbrains.spring_less_web.Repository.ClientRepository;

import java.util.List;

@Component
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;

    public List<Client> allClients() {
        return clientRepository.getAllClients();
    }

    public Client fiendClientsForId(Long id) {
        return clientRepository.findById(id);
    }
}
