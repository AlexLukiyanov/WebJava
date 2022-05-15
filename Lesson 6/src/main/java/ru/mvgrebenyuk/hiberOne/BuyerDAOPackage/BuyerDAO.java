package ru.mvgrebenyuk.hiberOne.BuyerDAOPackage;

import ru.mvgrebenyuk.hiberOne.Entityes.Buyer;
import ru.mvgrebenyuk.hiberOne.Entityes.Product;

import java.util.List;

public interface BuyerDAO {


    Buyer findById (Long id);

    void findProductByBuyerId (Long id);

    List<Buyer> findAll();

    void deleteById(Long id);

    Buyer saveOrUpdate(Buyer buyer);

}
