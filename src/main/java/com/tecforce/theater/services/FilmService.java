package com.tecforce.theater.services;

import com.tecforce.theater.annotations.Films;
import com.tecforce.theater.dao.FilmDao;
import com.tecforce.theater.data.entities.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Films
public class FilmService {
    @Autowired
    private FilmDao filmDao = new FilmDao();

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
    public void updateFilm(Film film) {
        filmDao.updateFilm(film);
    }

    @Transactional
    public void deleteFilm(long filmId) {
        filmDao.deleteFilm(filmId);
    }

}
