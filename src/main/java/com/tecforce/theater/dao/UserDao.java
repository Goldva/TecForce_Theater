package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public User getUserById(long userId) {
        return sessionFactory.getCurrentSession().get(User.class, userId);
    }

//    public Collection getAllUsers() {
//        return sessionFactory.getCriteriaBuilder().createQuery(User.class).list();
//    }

    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

}
