package com.tecforce.theater.services;

import com.tecforce.theater.dao.PlaceDao;
import com.tecforce.theater.data.entities.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlaceService {
    @Autowired
    private PlaceDao placeDao;

    @Transactional
    public void addPlace(Place place) {
        placeDao.addPlace(place);
    }


    @Transactional
    public Place getPlace(Place place) {
        return placeDao.getPlace(place);
    }

//    public Collection getAllHalls() {
//        return sessionFactory.getCriteriaBuilder().createQuery(Hall.class).list();
//    }

    @Transactional
    public void deletePlace(Place place) {
        placeDao.deletePlace(place);
    }

}
