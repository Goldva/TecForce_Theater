package com.tecforce.theater.services.DataServices;

import com.tecforce.theater.annotations.Statistics;
import com.tecforce.theater.dao.StatisticDao;
import com.tecforce.theater.data.entities.EntityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Statistics
public class StatisticService implements DataServiceInterface{
    @Autowired
    @Statistics
    private StatisticDao statisticDao;

    @Override
    @Transactional
    public void add(EntityInterface entity) {
        statisticDao.add(entity);
    }

    @Override
    @Transactional
    public EntityInterface getById(long entityId) {
        return statisticDao.getById(entityId);
    }

    @Override
    @Transactional
    public List<EntityInterface> getAll() {
        return statisticDao.getAll();
    }

    @Override
    @Transactional
    public EntityInterface getEntity(EntityInterface entity) {
        return statisticDao.getEntity(entity);
    }

    @Override
    @Transactional
    public List<EntityInterface> getEntities(EntityInterface entity) {
        return statisticDao.getEntities(entity);

    }

    @Override
    @Transactional
    public void update(EntityInterface entity) {
        statisticDao.update(entity);
    }

    @Override
    @Transactional
    public void delete(long entityId) {
        statisticDao.delete(entityId);
    }
}
