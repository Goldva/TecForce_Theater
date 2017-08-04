package com.tecforce.theater.dao;

import com.tecforce.theater.annotations.Halls;
import com.tecforce.theater.data.entities.EntityInterface;
import com.tecforce.theater.data.entities.Hall;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@Halls
public class HallDao implements DataDaoInterface {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(EntityInterface entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public EntityInterface getById(long entityId) {
        return sessionFactory.getCurrentSession().get(Hall.class, entityId);
    }

    @Override
    public List<EntityInterface> getAll() {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Hall> query = builder.createQuery(Hall.class);
        Root<Hall> root = query.from(Hall.class);
        query.select(root);

        return new ArrayList<>(sessionFactory.getCurrentSession().createQuery(query).getResultList());
    }

    @Override
    public EntityInterface getEntity(EntityInterface entity) {
        Hall hall = (Hall) entity;
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Hall> criteria = builder.createQuery(Hall.class);
        Root<Hall> root = criteria.from(Hall.class);

        criteria.select(root).where(builder.equal(root.get("hallName"), hall.getHallName()));

        List<Hall> result = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        return result.size() == 0 ? null : result.get(0);
    }

    @Override
    public List<EntityInterface> getEntities(EntityInterface entity) {
        return new ArrayList<>();                                                                                                  //TODO Дописать
    }

    @Override
    public void update(EntityInterface entity) {
        sessionFactory.getCurrentSession().merge(entity);
    }

    @Override
    public void delete(long entityId) {
        EntityInterface entity = getById(entityId);
        if (entity != null) {
            sessionFactory.getCurrentSession().delete(entity);
        }
    }
}