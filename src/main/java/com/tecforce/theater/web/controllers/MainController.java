package com.tecforce.theater.web.controllers;

import com.tecforce.theater.data.entities.Film;
import com.tecforce.theater.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class MainController {
    @Autowired
    private FilmService filmService;

//    @RequestMapping(value = {"/", "/index"})
//    public ModelAndView indexPage(Map<String, Object> map){
//        ModelAndView model = new ModelAndView();
//        model.addObject("messages", messageService.getMessages());
//        model.addObject("friends", friendService.getAllFriends());
//
//        model.setViewName("index");
//
//        return model;
//
////        map.put("messages", messageService.getMessages());
////        map.put("friends", friendService.getAllFriends());
////        return "index";
//    }

    @RequestMapping(value = {"/", "/index", "/theater"})
    public ModelAndView profile() throws IOException {
        System.out.println("sssssssssssssssss");
        ModelAndView model = new ModelAndView("/index.html");

//        model.setViewName("index.html");
        Film film = new Film();
        film.setDuration(111);
        film.setPrice(35);
        film.setTitle("QQwasdas");
        System.out.println("dddddddddd");
        filmService.addFilm(film);
        System.out.println("fffffffffffff");
        return model;
    }

    @RequestMapping(value = {"/qq", "/theater/qq"})
    public ModelAndView profileqq() throws IOException {
        System.out.println("sssssssssssssssss");
        ModelAndView model = new ModelAndView("/WEB-INF/views/sssss/index.jsp");

//        model.setViewName("WEB-INF/views/sssss/index.jsp");
        Film film = new Film();
        film.setDuration(111);
        film.setPrice(35);
        film.setTitle("QQwasdas");
        System.out.println("dddddddddd");
        filmService.addFilm(film);
        System.out.println("fffffffffffff");
        return model;
    }
}
