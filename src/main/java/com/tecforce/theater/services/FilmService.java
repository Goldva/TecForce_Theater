package com.tecforce.theater.services;

import com.tecforce.theater.dao.FilmDao;
import com.tecforce.theater.data.entities.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FilmService {
    @Autowired
    private FilmDao filmDao;

    @Transactional
    public void addFilm(Film film) {
        filmDao.addFilm(film);
    }

//    @Transactional
//    public Collection getAllFilms() {
//        return sessionFactory.getCriteriaBuilder().createQuery(Film.class).list();
//    }

    @Transactional
    public void deleteFilm(Film film) {
        filmDao.deleteFilm(film);
    }

}
