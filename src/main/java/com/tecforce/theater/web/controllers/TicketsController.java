package com.tecforce.theater.web.controllers;

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
    public @ResponseBody Ticket ticketsSelection(@RequestBody Ticket ticket) throws IOException {
        User user = null;
        if (ticket.getUserId() != -1) {
            user = userService.getUserById(ticket.getUserId());
        }
        return pricesService.getTicketWithRandomStock(ticket, user);
    }

    @RequestMapping(value = {"/buyTicket"})
    public void buyTicket(@RequestBody Set<Ticket> tickets) throws IOException {
        statisticService.addStatistics(tickets);
    }
}
