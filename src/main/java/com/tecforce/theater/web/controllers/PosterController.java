package com.tecforce.theater.web.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecforce.theater.data.entities.Film;
import com.tecforce.theater.data.entities.Hall;
import com.tecforce.theater.data.entities.Session;
import com.tecforce.theater.data.entities.User;
import com.tecforce.theater.services.FilmService;
import com.tecforce.theater.services.HallService;
import com.tecforce.theater.services.PricesService;
import com.tecforce.theater.services.SessionService;
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
    private PricesService pricesService;
    @Autowired
    private FilmService filmService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private HallService hallService;

    @RequestMapping(value = {"/getFilms"})
    public @ResponseBody
    String getFilms() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Film> films = filmService.getAllFilms();
        return mapper.writeValueAsString(films);
    }

    @RequestMapping(value = {"/getFilmSessions"})
    public @ResponseBody String getFilmSessions(@RequestBody String jsonReq) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Film film = mapper.readValue(jsonReq, Film.class);
        film = filmService.getFilmById(film.getId());
        return mapper.writeValueAsString(film.getSessions());
    }
    @RequestMapping(value = {"/getHalls"})
    public @ResponseBody String getHallFilms(@RequestBody String jsonReq) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readValue(jsonReq, JsonNode.class);
        Session session = mapper.readValue(node.get("session").toString(), Session.class);
        User user = mapper.readValue(node.get("user").asText(), User.class);
//        Session session = mapper.readValue(jsonReq, Session.class);
        session = sessionService.getSessionById(session.getId());

        Set<Hall> halls = session.getHalls();
        double price = session.getPrice();
        halls = pricesService.getPricesOfHallsForFilm(halls, price, user);

        return mapper.writeValueAsString(halls);
    }
    @RequestMapping(value = {"/getPlaces"})
    public @ResponseBody String getPlaces(@RequestBody String jsonReq) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Hall hall = mapper.readValue(jsonReq, Hall.class);
        hall = hallService.getHallById(hall.getId());
        return mapper.writeValueAsString(hall.getPlaces());
    }

}
