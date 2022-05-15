package ru.geekbrains.spring_less_web.ClientDAOPac;

import ru.geekbrains.spring_less_web.Model.Client;

import java.util.List;

public interface ClientDAO {


    Client findById (Long id);

    void findProductByClientId (Long id);

    List<Client> findAll();

    void deleteById(Long id);

    Client saveOrUpdate(Client buyer);

}
