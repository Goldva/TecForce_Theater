package com.tecforce.theater.services;

import com.tecforce.theater.dao.HallDao;
import com.tecforce.theater.data.entities.Hall;
import com.tecforce.theater.data.entities.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class HallService {
    @Autowired
    private HallDao hallDao;

    @Transactional
    public void addHall(Hall hall) {
        List<Place> places = hall.getPlaces();
        hall.setPlaces(new ArrayList<>());
        hallDao.addHall(hall);
        for (Place place : places){
            place.setHallId(hall.getId());
        }
        hall.setPlaces(places);
        hallDao.updateHall(hall);
    }

    @Transactional
    public void updateHall(Hall hall) {
        hallDao.updateHall(hall);
    }

    @Transactional
    public Hall getHallById(long hallId) {
        return hallDao.getHallById(hallId);
    }

    @Transactional
    public Hall getHall(Hall hall) {
        return hallDao.getHall(hall);
    }

    @Transactional
    public List<Hall> getAllHalls() {
        return hallDao.getAllHalls();
    }

    @Transactional
    public void deleteHall(long hallId) {
        hallDao.deleteHall(hallId);
    }

}
