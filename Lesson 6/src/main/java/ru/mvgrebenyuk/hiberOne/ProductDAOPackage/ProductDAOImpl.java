package ru.mvgrebenyuk.hiberOne.ProductDAOPackage;

import org.hibernate.Session;
import ru.mvgrebenyuk.hiberOne.Entityes.Buyer;
import ru.mvgrebenyuk.hiberOne.Entityes.Product;
import ru.mvgrebenyuk.hiberOne.Entityes.User;
import ru.mvgrebenyuk.hiberOne.SessionFactoryUtils;

import java.util.List;

public class ProductDAOImpl implements ProductDAO{

    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDAOImpl (SessionFactoryUtils sessionFactoryUtils){
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public void findBuyerByProductId(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            System.out.println(product.getBuyer());
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Product> product = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public Product saveOrUpdate(Product product) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        }
    }
}
