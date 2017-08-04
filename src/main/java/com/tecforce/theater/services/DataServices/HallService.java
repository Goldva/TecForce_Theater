package com.tecforce.theater.services.DataServices;

import com.tecforce.theater.annotations.Halls;
import com.tecforce.theater.dao.DataDaoInterface;
import com.tecforce.theater.data.entities.EntityInterface;
import com.tecforce.theater.data.entities.Hall;
import com.tecforce.theater.data.entities.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Halls
public class HallService implements DataServiceInterface{
    @Autowired
    @Halls
    private DataDaoInterface hallDao;

    @Transactional
    @Override
    public void add(EntityInterface entity) {
        Hall hall = (Hall)entity;
        List<Place> places = hall.getPlaces();
        hall.setPlaces(new ArrayList<>());
        hallDao.add(hall);
        for (Place place : places){
            place.setHallId(hall.getId());
        }
        hall.setPlaces(places);
        hallDao.update(hall);
    }

    @Transactional
    @Override
    public void update(EntityInterface entity) {
        hallDao.update(entity);
    }

    @Transactional
    @Override
    public EntityInterface getById(long entityId) {
        return hallDao.getById(entityId);
    }

    @Transactional
    @Override
    public EntityInterface getEntity(EntityInterface entity) {
        return hallDao.getEntity(entity);
    }

    @Transactional
    @Override
    public List<EntityInterface> getEntities(EntityInterface entity) {
        return hallDao.getEntities(entity);
    }

    @Transactional
    @Override
    public List<EntityInterface> getAll() {
        return hallDao.getAll();
    }

    @Transactional
    @Override
    public void delete(long entityId) {
        hallDao.delete(entityId);
    }
}
