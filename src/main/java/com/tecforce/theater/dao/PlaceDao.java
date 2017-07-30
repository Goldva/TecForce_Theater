package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.Place;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

@Repository
public class PlaceDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addPlace(Place place) {
        sessionFactory.getCurrentSession().save(place);
    }

    public Place getPlaceById(long placeId) {
        return sessionFactory.getCurrentSession().get(Place.class, placeId);
    }

    public Place getPlace(Place place) {
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

    public List<Place> getAllPlaces() {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Place> query = builder.createQuery(Place.class);
        Root<Place> root = query.from(Place.class);
        query.select(root);

        return sessionFactory.getCurrentSession().createQuery(query).getResultList();
    }

    public void deletePlace(Place place) {
        sessionFactory.getCurrentSession().delete(place);
    }


}
