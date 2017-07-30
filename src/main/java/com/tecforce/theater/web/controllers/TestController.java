package com.tecforce.theater.web.controllers;

import com.tecforce.theater.data.entities.Hall;
import com.tecforce.theater.data.entities.Session;
import com.tecforce.theater.data.entities.User;
import com.tecforce.theater.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

@Controller
public class TestController {
    @Autowired
    private FilmService filmService;

    @Autowired
    private UserService userService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private HallService hallService;

    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = {"/getSession"})
    public ModelAndView getSession() throws IOException {
        ModelAndView model = new ModelAndView("index.jsp");
        Session session = sessionService.getSessionById(2);
//        Set<Film> films = session.getFilms();
        Set<Hall> halls= session.getHalls();
        Hall hall = halls.iterator().next();
        hallService.updateHall(hall);
        session.getPrice();
        return model;
    }

    @RequestMapping(value = {"/createTestData"})
    public ModelAndView createTestData() throws IOException {
        ModelAndView model = new ModelAndView("index.jsp");
        for (int i = 0; i < 2; i++) {
            User user = new User();
            user.setUsername("Login" + i);
            user.setPassword("Password" + i);
            user.setBirthday(new Date());
            userService.addUser(user);
        }
//
//        for (int i = 0; i < 3; i++) {
//            Film film = new Film();
//            film.setDuration(i * 20 + 50);
//            film.setPrices(i *10 + 35);
//            film.setTitle("Film" + i);
//            filmService.addFilm(film);
//        }
//
//        for (int i = 0; i < 7; i++) {
//            Hall hall = new Hall();
//            hall.setHallName("HallName" + i);
//            hall.setRatioOrdinaryPlace(1.1);
//            hall.setRatioVipPlace(1.5);
//            hallService.addHall(hall);
//        }
//
//        for (int i = 1; i <= 10; i++) {
//            Place place = new Place();
//            place.setPlace(i);
//            place.setHallId(1);
//            placeService.addPlace(place);
//        }
//
////
//        for (int i = 1; i < 7; i++) {
//            Session session = new Session();
//            session.setTime(new Time(1111111111 * (i%3)));
//            session.setFilmId(i%3 +1);
//
//            Session searchSession = sessionService.getSession(session);
//            if (searchSession != null){
//                session = searchSession;
//                Hall hall = hallService.getHallById(i % 5 + 1);
//                session.addHall(hall);
//                sessionService.updateSession(session);
//            }else {
//
//                Hall hall = hallService.getHallById(i % 5 + 1);
//                session.addHall(hall);
//                sessionService.addSession(session);
//            }
//        }


        return model;
    }

}
