package com.tecforce.theater.web.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tecforce.theater.data.entities.Hall;
import com.tecforce.theater.data.entities.Session;
import com.tecforce.theater.data.entities.Statistics;
import com.tecforce.theater.data.entities.User;
import com.tecforce.theater.services.SessionService;
import com.tecforce.theater.services.StatisticService;
import com.tecforce.theater.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

@Controller
public class TicketsSelection {
    private int defaultPrice;
    private double stock = 1;
    private Session session;
    private User user = null;


    //TODO Удалить тестовые данные и доделать запрос
    String json =
            "{\"userId\":1, " +
                    "\"session\":[{" +
                    "\"sessionId\":2," +
                    "\"hallName\":\"HallName0\"," +
                    "\"placeId\":3," +
                    "\"free6ThTicket\":false" +
                    "}," +
                    "{" +
                    "\"sessionId\":2," +
                    "\"hallName\":\"HallName0\"," +
                    "\"placeId\":4," +
                    "\"free6ThTicket\":false" +
                    "}]}";


    @Autowired
    private UserService userService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value = {"/TicketsSelection"})
    public ModelAndView getFilms() throws IOException {
        JsonObject jsonSession = new Gson().fromJson(json, JsonObject.class);
        if (!jsonSession.get("userId").isJsonNull()) {
            user = userService.getUserById(jsonSession.get("userId").getAsLong());
        }
        JsonArray jsonArray = jsonSession.get("session").getAsJsonArray();
        ModelAndView model = new ModelAndView("index.jsp");

        int totalPrice = 0;

        if (jsonArray.size() >= 6){
            if (free6ThTicket()) {
                return model;                                                         //TODO Доделать запрос
            }
        }

        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject = (JsonObject) jsonElement;
            session = sessionService.getSessionById(jsonObject.get("sessionId").getAsLong());
            int placeId = jsonObject.get("placeId").getAsInt();
            defaultPrice = session.getPrice();
            if (jsonObject.get("free6ThTicket").getAsBoolean()){
                stock = 0;
            }else {
                freeTicket();
            }
            if (!(user == null)) {
                if (stock > 0) {
                    String hallName = jsonObject.get("hallName").getAsString();
                    ratioPlace(hallName, placeId);
                    birthdayStock();
                    stockForChildren();
                    free10thTicketForRegistered();
                }

                Statistics statistics = new Statistics();                           //TODO Создать и перенести в запрос покупки
                statistics.setUserId(user.getId());
                statistics.setSessionId(session.getId());
                statistics.setHallId(session.getHall(jsonObject.get("hallName").getAsString()).getId());
                statistics.setPlaceId(placeId);
                statistics.setPrice(defaultPrice);
                statisticService.addStatistic(statistics);
            }

            if (stock < 0 )
                stock = 0;
            totalPrice += defaultPrice * stock;
            System.out.println(defaultPrice * stock);
            stock = 1;
        }

        System.out.println(totalPrice);
        return model;
    }

    private void ratioPlace(String hallName, int placeId){
        Hall hall = session.getHall(hallName);
        defaultPrice *= hall.getRatio(placeId);

    }

    private void birthdayStock(){
        Date today = new Date();
        if (today.equals(user.getBirthday())) {
            stock -= 0.5;
        }
    }

    private void stockForChildren(){
        GregorianCalendar today = new GregorianCalendar();
        GregorianCalendar birthday = new GregorianCalendar();
        birthday.setTime(user.getBirthday());
        if (calcYears(birthday, today) < 14) {
            stock -= 0.25;
        }
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

    private void freeTicket(){
        Random r = new Random();
        if (r.nextInt(10) < 1){
            stock = 0;
        }
    }

    private boolean free6ThTicket(){
        return new Random().nextBoolean();
    }

    private void free10thTicketForRegistered(){
        List<Statistics> userStatistic = statisticService.getAllUserStatistics(user.getId());
        if (userStatistic.size() % 10 == 9){
            if (new Random().nextBoolean()){
                stock = 0;
            }
        }
    }

}
