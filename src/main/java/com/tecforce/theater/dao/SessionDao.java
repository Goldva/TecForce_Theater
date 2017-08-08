package com.tecforce.theater.dao;

import com.tecforce.theater.annotations.Sessions;
import com.tecforce.theater.data.entities.EntityInterface;
import com.tecforce.theater.data.entities.Film;
import com.tecforce.theater.data.entities.Session;
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
@Sessions
public class SessionDao  implements DataDaoInterface{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(EntityInterface entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public Session getById(long entityId) {
        return sessionFactory.getCurrentSession().get(Session.class, entityId);
    }

    @Override
    public EntityInterface getEntity(EntityInterface entity) {
        Session session = (Session) entity;
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Session> criteria = builder.createQuery(Session.class);
        Root<Session> root = criteria.from(Session.class);

        List<Predicate> predList = new LinkedList<>();
        predList.add(builder.equal(root.get("filmId"), session.getFilmId()));
        predList.add(builder.equal(root.get("time"), session.getTime()));
        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);

        criteria.select(root).where(predArray);

        List<Session> result = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        return result.size() == 0 ? null : result.get(0);
    }

    @Override
    public List<EntityInterface> getEntities(EntityInterface entity) {
        Film film = (Film) entity;
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Session> criteria = builder.createQuery(Session.class);
        Root<Session> root = criteria.from(Session.class);

        criteria.select(root).where(builder.equal(root.get("filmId"), film.getId()));

        return new ArrayList<>(sessionFactory.getCurrentSession().createQuery(criteria).getResultList());
    }

    @Override
    public List<EntityInterface> getAll() {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Session> criteria = builder.createQuery(Session.class);
        Root<Session> contactRoot = criteria.from(Session.class);
        criteria.select(contactRoot);

        return new ArrayList<>(sessionFactory.getCurrentSession().createQuery(criteria).getResultList());
    }

    @Override
    public void update(EntityInterface entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public void delete(long entityId) {
        EntityInterface entity = getById(entityId);
        if (entity != null) {
            sessionFactory.getCurrentSession().delete(entity);
        }
    }
}
