package ru.geekbrains.spring_less_web.Service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_less_web.ClientDAOPac.ClientDAOImpl;
import ru.geekbrains.spring_less_web.Model.Client;
import ru.geekbrains.spring_less_web.SessionFactoryUtils;

@Service
public class ClientService {

    @Autowired
    private ClientDAOImpl clientDAOImpl;

    @Autowired
    private SessionFactoryUtils sessionFactoryUtils;

    public ClientService(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public void changeScore(Long id, Integer score){
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Client client = clientDAOImpl.findById(id);
            client.setScore(client.getScore() + score);
            session.getTransaction().commit();
        }
    }
}
