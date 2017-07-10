package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.Film;

public interface FilmDao {
    public void addFilm(Film film);

//    public Collection getAllFilms() {
//        return sessionFactory.getCriteriaBuilder().createQuery(Film.class).list();
//    }

    public void deleteFilm(Film film);

}
