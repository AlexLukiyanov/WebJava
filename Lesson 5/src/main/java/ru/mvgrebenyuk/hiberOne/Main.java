package ru.mvgrebenyuk.hiberOne;

import ru.mvgrebenyuk.hiberOne.Entityes.Product;
import ru.mvgrebenyuk.hiberOne.ProductDAOPackage.ProductDAO;
import ru.mvgrebenyuk.hiberOne.ProductDAOPackage.ProductDAOImpl;

public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
            try {
                ProductDAO productDAO = new ProductDAOImpl(sessionFactoryUtils);

                System.out.println("All Products: " + productDAO.findAll());

                System.out.println("Find products by ID:" + productDAO.findById(2L));

                //Delete product by ID
                productDAO.deleteById(3L);
                System.out.println("Delete product:" + productDAO.findAll());

                Product product = new Product(4L, "Apple",30);
                productDAO.saveOrUpdate(product);
                System.out.println("Added new product:" + productDAO.findAll());

            } catch (Exception e){
                e.printStackTrace();
            } finally {
                sessionFactoryUtils.shotdown();
            }
    }
}
