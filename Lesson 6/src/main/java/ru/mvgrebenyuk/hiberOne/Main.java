package ru.mvgrebenyuk.hiberOne;

import ru.mvgrebenyuk.hiberOne.BuyerDAOPackage.BuyerDAO;
import ru.mvgrebenyuk.hiberOne.BuyerDAOPackage.BuyerDAOImpl;
import ru.mvgrebenyuk.hiberOne.Entityes.Product;
import ru.mvgrebenyuk.hiberOne.ProductDAOPackage.ProductDAO;
import ru.mvgrebenyuk.hiberOne.ProductDAOPackage.ProductDAOImpl;

public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
            try {
                //BuyerDAO buyerDAO = new BuyerDAOImpl(sessionFactoryUtils);
                //buyerDAO.findProductByBuyerId(2L);

                ProductDAO productDAO = new ProductDAOImpl(sessionFactoryUtils);
                productDAO.findBuyerByProductId(3L);


                //session.beginTransaction();
//            Book book = session.get(Book.class, 1L);
//            System.out.println(book);
//            System.out.println(book.getReaders());
//            session.getTransaction().commit();

                //            session.beginTransaction();
//            List<Reader> readers = session.createQuery("from Reader").getResultList();
//            List<Book> books = session.createQuery("from Book").getResultList();
//            readers.get(1).getBooks().add(books.get(5));
//            readers.get(1).getBooks().add(books.get(6));
//            session.getTransaction().commit();

//
                //System.out.println("All Products: " + productDAO.findAll());
//
                //System.out.println("Find products by ID:" + productDAO.findById(2L));
//
                ////Delete product by ID
                //productDAO.deleteById(3L);
                //System.out.println("Delete product:" + productDAO.findAll());
//
                //Product product = new Product(4L, "Apple",30);
                //productDAO.saveOrUpdate(product);
                //System.out.println("Added new product:" + productDAO.findAll());

                //            University universityFromNamedQuery = session
//                    .createNamedQuery("withStudents", University.class)
//                    .setParameter("id", 1L)
//                    .getSingleResult();
//            Student s = session.get(Student.class, 1L);
//            session.getTransaction().commit();


            } catch (Exception e){
                e.printStackTrace();
            } finally {
                sessionFactoryUtils.shotdown();
            }
    }
}
