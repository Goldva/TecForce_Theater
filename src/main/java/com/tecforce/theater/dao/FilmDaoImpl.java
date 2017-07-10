package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.Film;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FilmDaoImpl implements FilmDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addFilm(Film film) {
        sessionFactory.getCurrentSession().save(film);
    }

//    public Collection getAllFilms() {
//        return sessionFactory.getCriteriaBuilder().createQuery(Film.class).list();
//    }

    @Override
    public void deleteFilm(Film film) {
        sessionFactory.getCurrentSession().delete(film);
    }

}
