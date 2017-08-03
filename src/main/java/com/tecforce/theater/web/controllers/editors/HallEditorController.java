package com.tecforce.theater.web.controllers.editors;

import com.tecforce.theater.data.entities.Hall;
import com.tecforce.theater.data.entities.Session;
import com.tecforce.theater.data.entities.User;
import com.tecforce.theater.services.HallService;
import com.tecforce.theater.services.PricesService;
import com.tecforce.theater.services.SessionService;
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
    private SessionService sessionService;
    @Autowired
    private HallService hallService;


    @RequestMapping(value = "/editorHalls", method = RequestMethod.GET)
    public @ResponseBody List<Hall> getHalls() throws IOException {
        return hallService.getAllHalls();
    }

    @RequestMapping(value = "/editorHalls/sessionId={sessionId}", method = RequestMethod.POST)
    public @ResponseBody Set<Hall> getHallFilms(@PathVariable long sessionId, @RequestBody User user) throws IOException {
        if (user.equals(new User()))
            user = null;
        Session session = sessionService.getSessionById(sessionId);
        Set<Hall> halls = session.getHalls();
        double price = session.getPrice();

        return pricesService.getPricesOfHallsForFilm(halls, price, user);
    }

    @RequestMapping(value = "/editorHalls", method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.OK)
    public void createHall(@RequestBody Hall hall) throws IOException {
        hallService.addHall(hall);
    }

    @RequestMapping(value = "/editorHalls/{hallId}", method = RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.OK)
    public void deleteHall(@PathVariable long hallId) throws IOException {
        hallService.deleteHall(hallId);
    }

    @RequestMapping(value = "/editorHalls", method = RequestMethod.PUT)
    @ResponseStatus(value= HttpStatus.OK)
    public void updateHall(@RequestBody Hall hall) throws IOException {
        hallService.updateHall(hall);
    }
}
