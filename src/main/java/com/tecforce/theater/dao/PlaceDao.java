package com.tecforce.theater.dao;

import com.tecforce.theater.annotations.Places;
import com.tecforce.theater.data.entities.EntityInterface;
import com.tecforce.theater.data.entities.Place;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
@Places
public class PlaceDao implements DataDaoInterface{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(EntityInterface entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public EntityInterface getById(long entityId) {
        return sessionFactory.getCurrentSession().get(Place.class, entityId);
    }

    @Override
    public List<EntityInterface> getAll() {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Place> query = builder.createQuery(Place.class);
        Root<Place> root = query.from(Place.class);
        query.select(root);

        return new ArrayList<>(sessionFactory.getCurrentSession().createQuery(query).getResultList());
    }

    @Override
    public EntityInterface getEntity(EntityInterface entity) {
        Place place = (Place) entity ;
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Place> criteria = builder.createQuery(Place.class);
        Root<Place> root = criteria.from(Place.class);

        List<Predicate> predList = new LinkedList<>();
        predList.add(builder.equal(root.get("place"), place.getPlace()));
        predList.add(builder.equal(root.get("hall_id"), place.getHallId()));
        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);

        criteria.select(root).where(predArray);

        List<Place> result = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        return result.size() == 0 ? null : result.get(0);
    }

    @Override
    public List<EntityInterface> getEntities(EntityInterface entity) {
        return new ArrayList<>();                                                                                                   //TODO Дописать
    }

    @Override
    public void update(EntityInterface entity) {}                                                                                   //TODO Дописать

    @Override
    public void delete(long entityId) {
        EntityInterface entity = getById(entityId);
        if (entity != null) {
            sessionFactory.getCurrentSession().delete(entity);
        }
    }
}
