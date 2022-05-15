package ru.geekbrains.spring_less_web;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SessionFactoryUtils {
    private SessionFactory factory;

    @PostConstruct
    public void init(){
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    //@PostConstruct
    public Session getSession(){
        return factory.getCurrentSession();
    }

    @PostConstruct
    public void shotdown(){
        if(factory != null){
            factory.close();
        }
    }
}