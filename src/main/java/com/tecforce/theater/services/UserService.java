package com.tecforce.theater.services;

import com.tecforce.theater.dao.UserDao;
import com.tecforce.theater.data.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public User getUserById(long userId) {
        return userDao.getUserById(userId);
    }

//    public Collection getAllUsers() {
//        return sessionFactory.getCriteriaBuilder().createQuery(User.class).list();
//    }

    @Transactional
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

}
