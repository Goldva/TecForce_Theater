package com.tecforce.theater.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class MainController {

    @RequestMapping(value = {"/"})
    public ModelAndView profile() throws IOException {
        ModelAndView model = new ModelAndView("index.html");

//        model.setViewName("index.html");
//        Film film = new Film();
//        film.setDuration(111);
//        film.setPrice(35);
//        film.setTitle("QQwasdas");
//        filmService.addFilm(film);
        return model;
    }


    @RequestMapping(value = {"/start/{fileJS}"})
    public ModelAndView fileJS(@PathVariable String fileJS) throws IOException {
        ModelAndView model = new ModelAndView(fileJS + ".js");
        return model;
    }

    @RequestMapping(value = {"/start/css/{fileCSS}"})
    public ModelAndView fileCSS(@PathVariable String fileCSS) throws IOException {
        ModelAndView model = new ModelAndView("css/" + fileCSS + ".css");
        return model;
    }
}
