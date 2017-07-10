package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.Session;

public interface SessionDao {
    public void addSession(Session session);

//    public Collection getAllSessions() {
//        return sessionFactory.getCriteriaBuilder().createQuery(Session.class).list();
//    }

    public void deleteSession(Session session);

}
