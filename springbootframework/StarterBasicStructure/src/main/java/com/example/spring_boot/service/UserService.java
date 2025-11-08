package com.example.spring_boot.service;


import com.example.spring_boot.exceptions.UserAlreadyPresent;
import com.example.spring_boot.exceptions.UserNotFoundException;
import com.example.spring_boot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private final Logger logger= LoggerFactory.getLogger(UserService.class);
    private Map<Integer, User> userDb = new HashMap<>();
    public User createUser(User user)
    {
        if(userDb.containsKey(user.getId())) {
           throw new UserAlreadyPresent("User with id "+user.getId() +" already exists");
        }
        userDb.put(user.getId(), user);
        System.out.println(user.getEmail());
        return user;
    }

    public User updateUser(User user)
    {
        logger.info("Creating User...INFO");
        logger.debug("Creating User...DEBUG");
        logger.trace("Creating User...TRACE");
        logger.warn("Creating User...WARN");
        logger.error("Creating User...ERROR");
        if(!userDb.containsKey(user.getId())) {
            logger.error("Error when finding user with id {}: ",user.getId());
            throw new UserNotFoundException("User with id "+user.getId() +" does not exists");

        }
        userDb.put(user.getId(), user);
        return user;
    }

    public boolean deleteUser(int id) {


        if(!userDb.containsKey(id)){
            throw new UserNotFoundException("User with id "+id +" does not exsist");

        }
            userDb.remove(id);
            return true;

    }

    public List<User> getAllUsers() {
        if(userDb.isEmpty())
            throw new NullPointerException("No users found in the database");
        return new ArrayList<>(userDb.values());
    }

    public User getUserById(int id) {
        if(userDb.containsKey(id)) {
            return userDb.get(id);
        }
        return null;
    }

    public List<User> searchUsers(String name, String email) {
        return userDb.values().stream()
                .filter(u->u.getName().equalsIgnoreCase(name))
                .filter(u->u.getEmail().equalsIgnoreCase(email))
                .toList();

    }
}
