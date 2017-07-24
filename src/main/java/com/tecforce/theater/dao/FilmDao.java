package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.Film;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class FilmDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addFilm(Film film) {
        sessionFactory.getCurrentSession().save(film);
    }

    public Film getFilmById(long filmId) {
        return sessionFactory.getCurrentSession().get(Film.class, filmId);
    }

    public List<Film> getAllFilms() {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Film> criteria = builder.createQuery(Film.class);
        Root<Film> contactRoot = criteria.from(Film.class);
        criteria.select(contactRoot);

        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
    }

    public void deleteFilm(Film film) {
        sessionFactory.getCurrentSession().delete(film);
    }

}
