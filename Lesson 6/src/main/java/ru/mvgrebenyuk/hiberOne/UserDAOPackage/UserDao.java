package ru.mvgrebenyuk.hiberOne.UserDAOPackage;

import ru.mvgrebenyuk.hiberOne.Entityes.User;

import java.util.List;

public interface UserDao {

    User findById(Long id);

    List<User> findAll();

    User findByName(String name);

    void save(User user);

    void update(Long id, String name);

    void testCache();

}
