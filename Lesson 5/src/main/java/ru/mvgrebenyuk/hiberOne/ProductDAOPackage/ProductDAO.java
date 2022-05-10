package ru.mvgrebenyuk.hiberOne.ProductDAOPackage;


import ru.mvgrebenyuk.hiberOne.Entityes.Product;

import java.util.List;

public interface ProductDAO {

    Product findById (Long id);

    List<Product> findAll();

    void deleteById(Long id);

    Product saveOrUpdate(Product product);
}
