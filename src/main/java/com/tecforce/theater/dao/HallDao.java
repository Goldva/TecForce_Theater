package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.Hall;

public interface HallDao {
    public void addHall(Hall hall);

//    public Collection getAllHalls() {
//        return sessionFactory.getCriteriaBuilder().createQuery(Hall.class).list();
//    }

    public void deleteHall(Hall hall);

}
