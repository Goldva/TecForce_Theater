package com.tecforce.theater.services;

import com.tecforce.theater.dao.PlaceDao;
import com.tecforce.theater.data.entities.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlaceService {
    @Autowired
    private PlaceDao placeDao;

    @Transactional
    public void addPlace(Place place) {
        placeDao.addPlace(place);
    }

    @Transactional
    public Place getPlaceById(long placeId) {
        return placeDao.getPlaceById(placeId);
    }

    @Transactional
    public Place getPlace(Place place) {
        return placeDao.getPlace(place);
    }

    @Transactional
    public List<Place> getAllPlaces() {
        return placeDao.getAllPlaces();
    }

    @Transactional
    public void deletePlace(Place place) {
        placeDao.deletePlace(place);
    }

}
