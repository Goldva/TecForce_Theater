package com.tecforce.theater.web.controllers;

import com.tecforce.theater.annotations.*;
import com.tecforce.theater.data.entities.Hall;
import com.tecforce.theater.data.entities.Place;
import com.tecforce.theater.data.entities.Session;
import com.tecforce.theater.services.DataServices.DataServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Random;
import java.util.Set;

@Controller
public class TestController {
    @Autowired
    @Films
    private DataServiceInterface filmService;

    @Autowired
    @Users
    private DataServiceInterface userService;

    @Autowired
    @Sessions
    private DataServiceInterface sessionService;

    @Autowired
    @Halls
    private DataServiceInterface hallService;

    @Autowired
    @Places
    private DataServiceInterface placeService;

    @RequestMapping(value = {"/getSession"})
    public ModelAndView getSession() throws IOException {
        ModelAndView model = new ModelAndView("index.jsp");
        Session session = (Session) sessionService.getById(2);
//        Set<Film> films = session.getFilms();
        Set<Hall> halls= session.getHalls();
        Hall hall = halls.iterator().next();
        hallService.update(hall);
        session.getPrice();
        return model;
    }

    @RequestMapping(value = {"/createTestData"})
    public ModelAndView createTestData() throws IOException {
        ModelAndView model = new ModelAndView("index.jsp");
//        for (int i = 0; i < 2; i++) {
//            User user = new User();
//            user.setUsername("Login" + i);
//            user.setPassword("Password" + i);
//            user.setBirthday(new Date());
//            userService.add(user);
//        }
//
//        for (int i = 0; i < 3; i++) {
//            Film film = new Film();
//            film.setDuration(i * 20 + 50);
//            film.setPrice(i *10 + 35);
//            film.setTitle("Film" + i);
//            filmService.addFilm(film);
//        }

        for (int i = 0; i < 1; i++) {
            Hall hall = new Hall();
            hall.setHallName("HallName11" + new Random().nextInt(1000000));
            hall.setRatioOrdinaryPlace(1.1);
            hall.setRatioVipPlace(1.5);
            for (int j = 1; j <= 10; j++) {
                Place place = new Place();
                place.setPlace(j);
                hall.addPlace(place);
            }

            hallService.add(hall);
        }

//        Hall hall = hallService.getHallById(15);
//        for (int j = 1; j <= 10; j++) {
//            Place place = new Place();
//            place.setPlace(j);
//            place.setHallId(hall.getId());
//            hall.add(place);
//        }
//
//        hallService.updateHall(hall);


//        for (int i = 1; i <= 10; i++) {
//            Place place = new Place();
//            place.setPlace(i);
//            place.setHallId(1);
//            placeService.add(place);
//        }

//
//        for (int i = 10; i < 11; i++) {
//            Session session = new Session();
//            session.setTime(new Time(1111111111 * (i%3)));
//            session.setFilmId(i%3 +1);
//
//            Session searchSession = sessionService.getEntity(session);
//            if (searchSession != null){
//                session = searchSession;
//                Hall hall = hallService.getHallById(i % 5 + 1);
//                session.addHall(hall);
//                sessionService.update(session);
//            }else {
//
//                Hall hall = hallService.getHallById(i % 5 + 1);
//                session.addHall(hall);
//                sessionService.add(session);
//            }
//        }


        return model;
    }

}
