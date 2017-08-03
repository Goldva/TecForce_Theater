package com.tecforce.theater.web.controllers;

import com.tecforce.theater.data.entities.Film;
import com.tecforce.theater.data.entities.Hall;
import com.tecforce.theater.data.entities.Place;
import com.tecforce.theater.data.entities.Session;
import com.tecforce.theater.services.FilmService;
import com.tecforce.theater.services.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@Controller
public class PosterController {
    @Autowired
    private FilmService filmService;

    @Autowired
    private HallService hallService;


    @RequestMapping(value = {"/getFilmSessions"})
    public @ResponseBody Set<Session> getFilmSessions(@RequestBody Film film) throws IOException {
        film = filmService.getFilmById(film.getId());
        return film.getSessions();
    }
    @RequestMapping(value = {"/getPlaces"})
    public @ResponseBody List<Place> getPlaces(@RequestBody Hall hall) throws IOException {
        hall = hallService.getHallById(hall.getId());
        return hall.getPlaces();
    }

}
