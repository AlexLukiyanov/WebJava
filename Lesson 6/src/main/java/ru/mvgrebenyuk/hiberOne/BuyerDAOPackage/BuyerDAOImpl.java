package ru.mvgrebenyuk.hiberOne.BuyerDAOPackage;

import org.hibernate.Session;
import ru.mvgrebenyuk.hiberOne.Entityes.Buyer;
import ru.mvgrebenyuk.hiberOne.SessionFactoryUtils;

import java.util.List;

public class BuyerDAOImpl implements BuyerDAO{

    private SessionFactoryUtils sessionFactoryUtils;

    public BuyerDAOImpl (SessionFactoryUtils sessionFactoryUtils){
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Buyer findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.getTransaction().commit();
            return buyer;
        }
    }

    @Override
    public void findProductByBuyerId(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            System.out.println(buyer);
            System.out.println(buyer.getProduct());
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Buyer> findAll() {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Buyer> buyer = session.createQuery("select b from Buyer b").getResultList();
            session.getTransaction().commit();
            return buyer;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.delete(buyer);
            session.getTransaction().commit();
        }
    }

    @Override
    public Buyer saveOrUpdate(Buyer buyer) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(buyer);
            session.getTransaction().commit();
            return buyer;
        }
    }
}
