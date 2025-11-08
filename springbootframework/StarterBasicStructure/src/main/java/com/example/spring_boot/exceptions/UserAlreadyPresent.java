package com.example.spring_boot.exceptions;

public class UserAlreadyPresent extends RuntimeException{


    public UserAlreadyPresent(String message) {
        super(message);
    }
}
