package com.tecforce.theater;

import com.tecforce.theater.data.entities.User;
import com.tecforce.theater.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class Main {
    @Autowired
    private static UserService userService;

    public static void main(String[] args) {
        User user = new User();
        user.setBirthday(new Date());
        user.setLogin("goldva");
        user.setPassword("makros32");

        userService.addUser(user);
    }
}
