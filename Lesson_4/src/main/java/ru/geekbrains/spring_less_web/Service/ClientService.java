package ru.geekbrains.spring_less_web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_less_web.Model.Client;
import ru.geekbrains.spring_less_web.Repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public void changeScore(Long id, Integer score){
        Client client = repository.findById(id);
        client.setScore(client.getScore() + score);
        // repostitory.save(client);
    }

}
