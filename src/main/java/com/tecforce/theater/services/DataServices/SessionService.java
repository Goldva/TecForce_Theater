package com.tecforce.theater.services.DataServices;

import com.tecforce.theater.annotations.Sessions;
import com.tecforce.theater.dao.DataDaoInterface;
import com.tecforce.theater.data.entities.EntityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Sessions
public class SessionService implements DataServiceInterface{
    @Autowired
    @Sessions
    private DataDaoInterface sessionDao;

    @Override
    @Transactional
    public void add(EntityInterface entity) {
        sessionDao.add(entity);
    }

    @Override
    @Transactional
    public EntityInterface getById(long entityId) {
        return sessionDao.getById(entityId);
    }

    @Override
    @Transactional
    public List<EntityInterface> getAll() {
        return sessionDao.getAll();
    }

    @Override
    @Transactional
    public EntityInterface getEntity(EntityInterface entity) {
        return sessionDao.getEntity(entity);
    }

    @Override
    @Transactional
    public List<EntityInterface> getEntities(EntityInterface entity) {
        return sessionDao.getEntities(entity);
    }

    @Override
    @Transactional
    public void update(EntityInterface entity) {
        sessionDao.update(entity);
    }

    @Override
    @Transactional
    public void delete(long entityId) {
        sessionDao.delete(entityId);
    }
}
