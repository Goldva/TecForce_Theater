package com.tecforce.theater.services;

import com.tecforce.theater.dao.HallDao;
import com.tecforce.theater.data.entities.Hall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HallService {
    @Autowired
    private HallDao hallDao;

    @Transactional
    public void addHall(Hall hall) {
        hallDao.addHall(hall);
    }

    @Transactional
    public void updateHall(Hall hall) {
        hallDao.updateHall(hall);
    }

    @Transactional
    public Hall getHallById(long hallId) {
        return hallDao.getHallById(hallId);
    }

//    public Collection getAllHalls() {
//        return sessionFactory.getCriteriaBuilder().createQuery(Hall.class).list();
//    }

    @Transactional
    public void deleteHall(Hall hall) {
        hallDao.deleteHall(hall);
    }

}
