package com.tecforce.theater.web.controllers.editors;

import com.tecforce.theater.annotations.Halls;
import com.tecforce.theater.annotations.Sessions;
import com.tecforce.theater.data.entities.EntityInterface;
import com.tecforce.theater.data.entities.Hall;
import com.tecforce.theater.data.entities.Session;
import com.tecforce.theater.data.entities.User;
import com.tecforce.theater.services.DataServices.DataServiceInterface;
import com.tecforce.theater.services.DataServices.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@Controller
public class HallEditorController {
    @Autowired
    private PricesService pricesService;
    @Autowired
    @Sessions
    private DataServiceInterface sessionService;
    @Autowired
    @Halls
    private DataServiceInterface hallService;


    @RequestMapping(value = "/editorHalls", method = RequestMethod.GET)
    public @ResponseBody List<EntityInterface> getHalls() throws IOException {
        return hallService.getAll();
    }

    @RequestMapping(value = "/editorHalls/sessionId={sessionId}", method = RequestMethod.POST)
    public @ResponseBody Set<Hall> getHallFilms(@PathVariable long sessionId, @RequestBody User user) throws IOException {
        if (user.equals(new User()))
            user = null;
        Session session = (Session) sessionService.getById(sessionId);
        Set<Hall> halls = session.getHalls();
        double price = session.getPrice();

        return pricesService.getPricesOfHallsForFilm(halls, price, user);
    }

    @RequestMapping(value = "/editorHalls", method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.OK)
    public void createHall(@RequestBody Hall hall) throws IOException {
        hallService.add(hall);
    }

    @RequestMapping(value = "/editorHalls/{hallId}", method = RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.OK)
    public void deleteHall(@PathVariable long hallId) throws IOException {
        hallService.delete(hallId);
    }

    @RequestMapping(value = "/editorHalls", method = RequestMethod.PUT)
    @ResponseStatus(value= HttpStatus.OK)
    public void updateHall(@RequestBody Hall hall) throws IOException {
        hall.setSessions(((Hall)hallService.getById(hall.getId())).getSessions());                                              //TODO Написать слой DTO
        hallService.update(hall);
    }
}
