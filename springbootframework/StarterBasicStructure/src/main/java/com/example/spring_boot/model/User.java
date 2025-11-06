package com.example.spring_boot.model;


//POJO class -> Plain old java object
public class User {

    private int id;
    private String name;
    private String email;


    public User(String email, int id, String name) {
        this.email = email;
        this.id = id;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
