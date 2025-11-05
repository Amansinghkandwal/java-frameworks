package com.aman.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import com.aman.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(String user)
    {
        userService.addUser(user);
    }

    public void ListUsers()
    {
        List<String> users= userService.getAllUsers();
        System.out.println("All users: "+users);
    }
}
