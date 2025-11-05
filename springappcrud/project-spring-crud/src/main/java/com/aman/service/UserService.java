package com.aman.service;

import org.springframework.stereotype.Service;
import com.aman.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String user) {
        userRepository.save(user);
    }

    public List<String> getAllUsers() {
        return userRepository.findAll();
    }
}
