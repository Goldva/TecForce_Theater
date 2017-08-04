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
        return new ModelAndView("index.html");
    }

    @RequestMapping(value = {"/{fileJS}"})
    public ModelAndView fileJS(@PathVariable String fileJS) throws IOException {
        return new ModelAndView(fileJS + ".js");
    }
}
