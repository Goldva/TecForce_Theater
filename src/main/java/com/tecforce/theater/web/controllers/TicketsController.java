package com.tecforce.theater.web.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecforce.theater.data.entities.Ticket;
import com.tecforce.theater.data.entities.User;
import com.tecforce.theater.services.PricesService;
import com.tecforce.theater.services.StatisticService;
import com.tecforce.theater.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Set;

@Controller
public class TicketsController {
    @Autowired
    private UserService userService;

    @Autowired
    private PricesService pricesService;

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value = {"/ticketsSelection"})
    public @ResponseBody String ticketsSelection(@RequestBody String jsonReq) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Ticket ticket = mapper.readValue(jsonReq, Ticket.class);
        User user = userService.getUserById(ticket.getUserId());

        ticket = pricesService.getTicketWithRandomStock(ticket, user);

        return mapper.writeValueAsString(ticket);
    }

    @RequestMapping(value = {"/buyTicket"})
    public void buyTicket(@RequestBody String jsonReq) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Set<Ticket> tickets = mapper.readValue(jsonReq, new TypeReference<Set<Ticket>>(){});

        statisticService.addStatistics(tickets);
    }
}
