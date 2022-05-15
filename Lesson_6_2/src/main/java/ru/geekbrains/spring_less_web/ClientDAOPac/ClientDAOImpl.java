package ru.geekbrains.spring_less_web.ClientDAOPac;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring_less_web.Model.Client;
import ru.geekbrains.spring_less_web.SessionFactoryUtils;


import java.util.List;

@Component
@Scope("prototype")
public class ClientDAOImpl implements ClientDAO{

    @Autowired
    private SessionFactoryUtils sessionFactoryUtils;

    public ClientDAOImpl(SessionFactoryUtils sessionFactoryUtils){
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Client findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.getTransaction().commit();
            return client;
        }
    }

    @Override
    public void findProductByClientId(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            System.out.println(client);
            System.out.println(client.getProduct());
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Client> findAll() {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Client> client = session.createQuery("select c from Client c").getResultList();
            session.getTransaction().commit();
            return client;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.delete(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public Client saveOrUpdate(Client client) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(client);
            session.getTransaction().commit();
            return client;
        }
    }
}
