package ru.geekbrains.spring_less_web.Service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_less_web.Model.Product;
import ru.geekbrains.spring_less_web.ProductDAOPac.ProductDAOImpl;
import ru.geekbrains.spring_less_web.SessionFactoryUtils;

@Service
public class ProductService {

    @Autowired
    private ProductDAOImpl productDAOImpl;

    @Autowired
    private SessionFactoryUtils sessionFactoryUtils;

    public ProductService(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public void changeScoreProduct(Long id, Integer amount){
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = productDAOImpl.findById(id);
            product.setAmount(product.getAmount() + amount);
            session.getTransaction().commit();
        }
    }
}
