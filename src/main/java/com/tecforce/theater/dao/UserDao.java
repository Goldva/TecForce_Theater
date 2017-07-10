package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.User;

public interface UserDao {
    public void addUser(User user);

//    public Collection getAllUsers() {
//        return sessionFactory.getCriteriaBuilder().createQuery(User.class).list();
//    }

    public void deleteUser(User user);

}
