package com.aman.Main;

import com.aman.config.ConfigApp;
import com.aman.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        UserController controller = context.getBean(UserController.class);

        controller.createUser("Aman");
        controller.createUser("Alice");
        controller.createUser("Bob");

        controller.ListUsers();


    }
}
