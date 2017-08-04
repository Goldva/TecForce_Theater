package com.tecforce.theater.web.controllers.editors;

import com.tecforce.theater.annotations.Films;
import com.tecforce.theater.data.entities.EntityInterface;
import com.tecforce.theater.data.entities.Film;
import com.tecforce.theater.services.DataServices.DataServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class FilmEditorController {
    @Autowired
    @Films
    private DataServiceInterface filmService;

    @RequestMapping(value = "/editorFilm", method = RequestMethod.GET)
    public @ResponseBody List<EntityInterface> getFilms() throws IOException {
        return filmService.getAll();
    }

    @RequestMapping(value = "/editorFilm", method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.OK)
    public void createFilms(@RequestBody Film film) throws IOException {
        filmService.add(film);
    }

    @RequestMapping(value = "/editorFilm/{filmId}", method = RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.OK)
    public void deleteFilm(@PathVariable long filmId) throws IOException {
        filmService.delete(filmId);
    }

    @RequestMapping(value = "/editorFilm", method = RequestMethod.PUT)
    @ResponseStatus(value= HttpStatus.OK)
    public void updateFilm(@RequestBody Film film) throws IOException {
        filmService.update(film);
    }

}
