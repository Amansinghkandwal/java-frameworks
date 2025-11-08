package com.example.spring_boot.controller;


import com.example.spring_boot.model.User;
import org.springframework.web.bind.annotation.*;




//jackson library is converting this mapping into JSON format
//Browser -> /user -> created POJO -> spring-boot  ->Json ->JSON output
//api/user or api/user/1 or /api/users -> @RequestMapping("/api") in class level
@RequestMapping("/api")
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello()
    {
        return "Hello World";

    }

    //@GetMapping("/user")
    @RequestMapping(value="/user",method = RequestMethod.GET)
    public User getUser()
    {
        User user= new User("example@gmail.com",1,"Bob");
        return user;
        //jackson needs user field access and that can be possible by getters
    }
    /*
    API -> Application programming Interface
    REST API -> Representational State Transfer -> JSON format
    STATUS CODE -> 1xx Informational response
                   2xx successful
                   3xx redirection
                   4xx client error
                   5xx server error
    REQUEST - > GET,POST,DELETE,PUT,PATCH
     */

    /*
    Browser/Postman
        |
    TomCat (Web Server)
        |
    DispatcherServlet
        |
    HandlerMapping
        |
    Controller
        |
    MVC -> HttpMessageConverter
        |
    Response ->Tomcat
     */

}
