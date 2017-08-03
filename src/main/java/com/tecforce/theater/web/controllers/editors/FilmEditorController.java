package com.tecforce.theater.web.controllers.editors;

import com.tecforce.theater.data.entities.Film;
import com.tecforce.theater.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class FilmEditorController {
    @Autowired
    private FilmService filmService;

    @RequestMapping(value = "/editorFilm", method = RequestMethod.GET)
    public @ResponseBody List<Film> getFilms() throws IOException {
        return filmService.getAllFilms();
    }

    @RequestMapping(value = "/editorFilm", method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.OK)
    public void createFilms(@RequestBody Film film) throws IOException {
        filmService.addFilm(film);
    }

    @RequestMapping(value = "/editorFilm/{filmId}", method = RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.OK)
    public void deleteFilm(@PathVariable long filmId) throws IOException {
        filmService.deleteFilm(filmId);
    }

    @RequestMapping(value = "/editorFilm", method = RequestMethod.PUT)
    @ResponseStatus(value= HttpStatus.OK)
    public void updateFilm(@RequestBody Film film) throws IOException {
        filmService.updateFilm(film);
    }

}
