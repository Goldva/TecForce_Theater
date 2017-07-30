package com.tecforce.theater.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecforce.theater.data.entities.User;
import com.tecforce.theater.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/authenticate"})
    public @ResponseBody
    String ticketsSelection(@RequestBody String jsonReq) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(jsonReq, User.class);

        user = userService.authenticate(user);
        return mapper.writeValueAsString(user);
    }

}
