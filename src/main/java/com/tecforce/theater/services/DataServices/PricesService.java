package com.tecforce.theater.services.DataServices;

import com.tecforce.theater.data.entities.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class PricesService {
    private final double FREE_TICKET = 1;
    private final double BIRTHDAY_STOCK = 0.5;
    private final double STOCK_FOR_CHILDREN = 0.25;

    private User user = null;
    private List<String> stocksList = new ArrayList<>();

    public void buyTickets(Set<Ticket> tickets){

    }

    public Ticket getTicketWithRandomStock(Ticket ticket, User user) throws IOException {
        stocksList = ticket.getStocks();
        this.user = user;
        double filmPrice = ticket.getHall().getPriceForPlace(ticket.getPlace().isVipPlace());

        double stock = 1;

        if (ticket.isIs6ThTicket()) {
            stock -= FREE_TICKET;
            stocksList.add("При покупки 5-и билетов, 6-ой бесплатно");
        } else {
            stock -= freeTicket();
        }
        if (user != null) {
            stock -= free10thTicketForRegistered(ticket.isIs10ThTicket());
        }

        if (stock < 0)
            stock = 0;
        ticket.setPrice(filmPrice * stock);
        return ticket;
    }

    public Set<Hall> getPricesOfHallsForFilm(Set<Hall> halls, double filmPrice, User user){
        for (Hall hall : halls){
            this.user = user;
            pricesForTypePlaces(hall, filmPrice);
            if (user != null) {
                double stock = 1;
                stock -= birthdayStock();
                stock -= stockForChildren();
                hall.setOrdinaryPrice(hall.getOrdinaryPrice() * stock);
                hall.setVipPrice(hall.getVipPrice() * stock);
            }
        }
        return halls;
    }

    private void pricesForTypePlaces(Hall hall, double filmPrice){
        hall.setVipPrice(filmPrice * hall.getRatioVipPlace());
        hall.setOrdinaryPrice(filmPrice * hall.getRatioOrdinaryPlace());
    }

    private double birthdayStock(){
        GregorianCalendar today = new GregorianCalendar();
        today.setTime(new Date());
        Calendar birthday = new GregorianCalendar();
        birthday.setTime(user.getBirthday());
        double stock =  0;
        if (today.get(Calendar.MONTH) == birthday.get(Calendar.MONTH)){
            if (today.get(Calendar.DAY_OF_MONTH) == birthday.get(Calendar.DAY_OF_MONTH)){
                stock = BIRTHDAY_STOCK;
                stocksList.add("В день рождения скидка 50%");

            }
        }
        return stock;
    }

    private double stockForChildren(){
        GregorianCalendar today = new GregorianCalendar();
        GregorianCalendar birthday = new GregorianCalendar();
        birthday.setTime(user.getBirthday());
        double stock = 0;
        if (calcYears(birthday, today) < 14){
            stock = STOCK_FOR_CHILDREN;
            stocksList.add("Детям до 14 дет скидка 25%");
        }
        return stock;
    }

    private int calcYears(GregorianCalendar birthday, GregorianCalendar today) {
        int years = today.get(GregorianCalendar.YEAR) - birthday.get(GregorianCalendar.YEAR);
        int checkMonth = today.get(GregorianCalendar.MONTH);
        int birthMonth = birthday.get(GregorianCalendar.MONTH);
        if ( checkMonth < birthMonth ) {
            years --;
        } else  if (checkMonth == birthMonth
                && today.get(GregorianCalendar.DAY_OF_MONTH) < birthday.get(GregorianCalendar.DAY_OF_MONTH)) {
            years --;
        }
        return years;
    }

    private double freeTicket(){
        Random r = new Random();
        double stock = 0;
        if (r.nextInt(10) < 1){
            stock = FREE_TICKET;
            stocksList.add("С вероятностью 10% вы можете получить билет бесплатно");
        }
        return stock;
    }

    private boolean free6ThTicket(){
        return new Random().nextBoolean();
    }

    private double free10thTicketForRegistered(boolean is10ThTicket){
        double stock = 0;
        if (is10ThTicket){
            if (new Random().nextBoolean()){
                stock = FREE_TICKET;
                stocksList.add("Каждый 10-ый былет вы можете получить бесплатно");
            }
        }
        return stock;
    }


}
