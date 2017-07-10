package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.Hall;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HallDaoImpl implements HallDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addHall(Hall hall) {
        sessionFactory.getCurrentSession().save(hall);
    }

//    public Collection getAllHalls() {
//        return sessionFactory.getCriteriaBuilder().createQuery(Hall.class).list();
//    }

    @Override
    public void deleteHall(Hall hall) {
        sessionFactory.getCurrentSession().delete(hall);
    }

}
