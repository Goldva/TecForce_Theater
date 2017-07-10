package com.tecforce.theater.services;

import com.tecforce.theater.dao.SessionDao;
import com.tecforce.theater.data.entities.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SessionService {
    @Autowired
    private SessionDao sessionDao;

    @Transactional
    public void addSession(Session session) {
        sessionDao.addSession(session);
    }

//    public Collection getAllSessions() {
//        return sessionFactory.getCriteriaBuilder().createQuery(Session.class).list();
//    }

    @Transactional
    public void deleteSession(Session session) {
        sessionDao.deleteSession(session);
    }

}
