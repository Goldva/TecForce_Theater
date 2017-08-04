package com.tecforce.theater.web.controllers;

import com.tecforce.theater.annotations.Statistics;
import com.tecforce.theater.annotations.Users;
import com.tecforce.theater.data.entities.Ticket;
import com.tecforce.theater.data.entities.User;
import com.tecforce.theater.services.DataServices.DataServiceInterface;
import com.tecforce.theater.services.DataServices.PricesService;
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
    @Users
    private DataServiceInterface userService;

    @Autowired
    private PricesService pricesService;

    @Autowired
    @Statistics
    private DataServiceInterface statisticService;

    @RequestMapping(value = {"/ticketsSelection"})
    public @ResponseBody Ticket ticketsSelection(@RequestBody Ticket ticket) throws IOException {
        User user = null;
        if (ticket.getUserId() != -1) {
            user = (User) userService.getById(ticket.getUserId());
        }
        return pricesService.getTicketWithRandomStock(ticket, user);
    }

    @RequestMapping(value = {"/buyTicket"})
    public void buyTicket(@RequestBody Set<Ticket> tickets) throws IOException {
        for (Ticket ticket : tickets) {
            statisticService.add(ticket);
        }
    }
}
