package com.tecforce.theater.web.controllers;

import com.tecforce.theater.data.entities.User;
import com.tecforce.theater.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public @ResponseBody User ticketsSelection(@RequestBody User user) throws IOException {
        return userService.authenticate(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody List<User> getUsers() throws IOException {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.OK)
    public void createUser(@RequestBody User user) throws IOException {
        userService.addUser(user);
    }
}
