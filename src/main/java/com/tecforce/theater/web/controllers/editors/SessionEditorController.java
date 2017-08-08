package com.tecforce.theater.web.controllers.editors;

import com.tecforce.theater.annotations.Films;
import com.tecforce.theater.annotations.Sessions;
import com.tecforce.theater.data.entities.*;
import com.tecforce.theater.services.DataServices.DataServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@Controller
public class SessionEditorController {
    @Autowired
    @Sessions
    private DataServiceInterface sessionService;
    @Autowired
    @Films
    private DataServiceInterface filmService;

    @RequestMapping(value = "/editorSessions", method = RequestMethod.GET)
    public @ResponseBody List<EntityInterface> getSessions() throws IOException {
        return sessionService.getAll();
    }

    @RequestMapping(value = "/editorSessions/filmId={filmId}", method = RequestMethod.POST)
    public @ResponseBody Set<Session> getFilmSessions(@PathVariable long filmId) throws IOException {
        Film film = (Film) filmService.getById(filmId);
        return film.getSessions();
    }

    @RequestMapping(value = "/editorSessions", method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.OK)
    public void createSession(@RequestBody Session session) throws IOException {
        sessionService.add(session);
    }

    @RequestMapping(value = "/editorSessions/{sessionId}", method = RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.OK)
    public void deleteSession(@PathVariable long sessionId) throws IOException {
        sessionService.delete(sessionId);
    }

    @RequestMapping(value = "/editorSessions", method = RequestMethod.PUT)
    @ResponseStatus(value= HttpStatus.OK)
    public void updateHall(@RequestBody Session session) throws IOException {
        sessionService.update(session);
    }
}
