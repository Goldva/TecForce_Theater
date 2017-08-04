package com.tecforce.theater.dao;

import com.tecforce.theater.annotations.Films;
import com.tecforce.theater.data.entities.EntityInterface;
import com.tecforce.theater.data.entities.Film;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@Films
public class FilmDao implements DataDaoInterface{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(EntityInterface entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public EntityInterface getById(long entityId) {
        return sessionFactory.getCurrentSession().get(Film.class, entityId);
    }

    @Override
    public List<EntityInterface> getAll() {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Film> criteria = builder.createQuery(Film.class);
        Root<Film> contactRoot = criteria.from(Film.class);
        criteria.select(contactRoot);

        return new ArrayList<>(sessionFactory.getCurrentSession().createQuery(criteria).getResultList());
    }

    @Override
    public EntityInterface getEntity(EntityInterface entity) {
        return new Film();                                                                                                      //TODO Дописать
    }

    @Override
    public List<EntityInterface> getEntities(EntityInterface entity) {
        return new ArrayList<>();                                                                                               //TODO Дописать
    }

    @Override
    public void update(EntityInterface entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public void delete(long entityId) {
        EntityInterface entity =  getById(entityId);
        if (entity != null) {
            sessionFactory.getCurrentSession().delete(entity);
        }
    }
}
