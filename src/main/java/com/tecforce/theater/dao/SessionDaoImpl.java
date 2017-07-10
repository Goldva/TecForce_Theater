package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SessionDaoImpl implements SessionDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSession(Session session) {
        sessionFactory.getCurrentSession().save(session);
    }

//    public Collection getAllSessions() {
//        return sessionFactory.getCriteriaBuilder().createQuery(Session.class).list();
//    }

    @Override
    public void deleteSession(Session session) {
        sessionFactory.getCurrentSession().delete(session);
    }

}
