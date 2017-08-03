package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.Hall;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class HallDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addHall(Hall hall) {
        sessionFactory.getCurrentSession().save(hall);
    }

    public void updateHall(Hall hall) {
        sessionFactory.getCurrentSession().merge(hall);
    }

    public Hall getHallById(long hallId) {
        return sessionFactory.getCurrentSession().get(Hall.class, hallId);
    }

    public Hall getHall(Hall hall) {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Hall> criteria = builder.createQuery(Hall.class);
        Root<Hall> root = criteria.from(Hall.class);

        criteria.select(root).where(builder.equal(root.get("hallName"), hall.getHallName()));

        List<Hall> result = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        return result.size() == 0 ? null : result.get(0);
    }

    public List<Hall> getAllHalls() {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Hall> query = builder.createQuery(Hall.class);
        Root<Hall> root = query.from(Hall.class);
        query.select(root);

        return sessionFactory.getCurrentSession().createQuery(query).getResultList();
    }

    public void deleteHall(long hallId) {
        Hall hall = getHallById(hallId);
        if (hall != null) {
            sessionFactory.getCurrentSession().delete(hall);
        }
    }
}
