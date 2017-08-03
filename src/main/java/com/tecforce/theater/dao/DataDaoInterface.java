package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.Film;

import java.util.List;

public interface DataDaoInterface {
    void add(Film film);

    Film getById(long filmId);

    List<Film> getAll();
    void updateFilm(Film film);

    void delete(long filmId);

}
