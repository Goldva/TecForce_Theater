package com.tecforce.theater.services;

import com.tecforce.theater.dao.FilmDao;
import com.tecforce.theater.data.entities.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    private FilmDao filmDao;

    @Transactional
    public void addFilm(Film film) {
        filmDao.addFilm(film);
    }

    @Transactional
    public Film getFilmById(long filmId) {
        return filmDao.getFilmById(filmId);
    }

    @Transactional
    public List<Film> getAllFilms() {
        return filmDao.getAllFilms();
    }

    @Transactional
    public void deleteFilm(Film film) {
        filmDao.deleteFilm(film);
    }

}
