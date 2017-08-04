package com.tecforce.theater.services.DataServices;

import com.tecforce.theater.annotations.Places;
import com.tecforce.theater.dao.DataDaoInterface;
import com.tecforce.theater.data.entities.EntityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Places
public class PlaceService implements DataServiceInterface{
    @Autowired
    @Places
    private DataDaoInterface placeDao;

    @Override
    @Transactional
    public void add(EntityInterface entity) {
        placeDao.add(entity);
    }

    @Override
    @Transactional
    public EntityInterface getById(long entityId) {
        return placeDao.getById(entityId);
    }

    @Override
    @Transactional
    public List<EntityInterface> getAll() {
        return placeDao.getAll();
    }

    @Override
    @Transactional
    public EntityInterface getEntity(EntityInterface entity) {
        return placeDao.getEntity(entity);
    }

    @Transactional
    @Override
    public List<EntityInterface> getEntities(EntityInterface entity) {
        return placeDao.getEntities(entity);
    }

    @Transactional
    @Override
    public void update(EntityInterface entity) {
        placeDao.update(entity);
    }


    @Override
    @Transactional
    public void delete(long entityId) {
        placeDao.delete(entityId);
    }
}
