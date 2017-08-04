package com.tecforce.theater.web.controllers;

import com.tecforce.theater.annotations.Users;
import com.tecforce.theater.data.entities.EntityInterface;
import com.tecforce.theater.data.entities.User;
import com.tecforce.theater.services.DataServices.DataServiceInterface;
import com.tecforce.theater.services.DataServices.UsersServices.Authenticate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    @Users
    private DataServiceInterface userService;

    @Autowired
    private Authenticate authenticate;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public @ResponseBody User ticketsSelection(@RequestBody User user) throws IOException {
        return authenticate.authenticate(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody List<EntityInterface> getUsers() throws IOException {
        return userService.getAll();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.OK)
    public void createUser(@RequestBody User user) throws IOException {
        userService.add(user);
    }
}
