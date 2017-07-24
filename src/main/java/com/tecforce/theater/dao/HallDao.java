package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.Hall;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HallDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addHall(Hall hall) {
        sessionFactory.getCurrentSession().save(hall);
    }

    public void updateHall(Hall hall) {
        sessionFactory.getCurrentSession().update(hall);
    }

    public Hall getHallById(long hallId) {
        return sessionFactory.getCurrentSession().get(Hall.class, hallId);
    }

//    public Collection getAllHalls() {
//        return sessionFactory.getCriteriaBuilder().createQuery(Hall.class).list();
//    }

    public void deleteHall(Hall hall) {
        sessionFactory.getCurrentSession().delete(hall);
    }

}
