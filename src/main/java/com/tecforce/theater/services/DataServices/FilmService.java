package com.tecforce.theater.services.DataServices;

import com.tecforce.theater.annotations.Films;
import com.tecforce.theater.dao.DataDaoInterface;
import com.tecforce.theater.data.entities.EntityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Films
public class FilmService implements DataServiceInterface {
    @Autowired
    @Films
    private DataDaoInterface filmDao;

    @Transactional
    @Override
    public void add(EntityInterface entity) {
        filmDao.add(entity);
    }

    @Transactional
    @Override
    public EntityInterface getById(long entityId) {
        return filmDao.getById(entityId);
    }

    @Transactional
    @Override
    public List<EntityInterface> getAll() {
        return filmDao.getAll();
    }

    @Transactional
    @Override
    public EntityInterface getEntity(EntityInterface entity) {
        return filmDao.getEntity(entity);
    }

    @Transactional
    @Override
    public List<EntityInterface> getEntities(EntityInterface entity) {
        return filmDao.getEntities(entity);
    }

    @Transactional
    @Override
    public void update(EntityInterface entity) {
        filmDao.update(entity);
    }

    @Transactional
    @Override
    public void delete(long entityId) {
        filmDao.delete(entityId);
    }
}
