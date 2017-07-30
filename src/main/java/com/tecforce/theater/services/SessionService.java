package com.tecforce.theater.services;

import com.tecforce.theater.dao.SessionDao;
import com.tecforce.theater.data.entities.Film;
import com.tecforce.theater.data.entities.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SessionService {
    @Autowired
    private SessionDao sessionDao;

    @Transactional
    public void addSession(Session session) {
        sessionDao.addSession(session);
    }

    @Transactional
    public void updateSession(Session session) {
        sessionDao.updateSession(session);
    }

    @Transactional
    public Session getSessionById(long sessionId) {
        return sessionDao.getSessionById(sessionId);
    }

    @Transactional
    public Session getSession(Session session) {
        Session result = sessionDao.getSession(session);
        return result;
    }

    @Transactional
    public List<Session> getAllSessions() {
        return sessionDao.getAllSessions();
    }

    @Transactional
    public List<Session> getAllSessionsForFilm(Film film) {
        return sessionDao.getAllSessionsForFilm(film);
    }

    @Transactional
    public void deleteSession(Session session) {
        sessionDao.deleteSession(session);
    }

}
