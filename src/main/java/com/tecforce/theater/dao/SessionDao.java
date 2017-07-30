package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.Film;
import com.tecforce.theater.data.entities.Session;
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
public class SessionDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addSession(Session session) {
        sessionFactory.getCurrentSession().save(session);
    }

    public void updateSession(Session session) {
        sessionFactory.getCurrentSession().update(session);
    }

    public Session getSessionById(long sessionId) {
        return sessionFactory.getCurrentSession().get(Session.class, sessionId);
    }

    public Session getSession(Session session) {
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

    public List<Session> getAllSessionsForFilm(Film film) {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Session> criteria = builder.createQuery(Session.class);
        Root<Session> root = criteria.from(Session.class);

        criteria.select(root).where(builder.equal(root.get("filmId"), film.getId()));

        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
    }


    public List<Session> getAllSessions() {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Session> criteria = builder.createQuery(Session.class);
        Root<Session> contactRoot = criteria.from(Session.class);
        criteria.select(contactRoot);

        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
    }

    public void deleteSession(Session session) {
        sessionFactory.getCurrentSession().delete(session);
    }

}
