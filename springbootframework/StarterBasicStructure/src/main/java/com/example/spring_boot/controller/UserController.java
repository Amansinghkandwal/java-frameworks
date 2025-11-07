package com.example.spring_boot.controller;


import com.example.spring_boot.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
  Response Entity -> we need to improve the api responses to tell the correct status
  HTTP response + Status Code


 */

@RestController
@RequestMapping("/user")
public class UserController {
    private Map<Integer, User> userDb = new HashMap<>();

    @PostMapping
    //we are doing a post request -> request->(requestHeader , requestBody)
    public ResponseEntity<User> createUser(@RequestBody User user)
    {

       if(!userDb.containsKey(user.getId())) {
           userDb.put(user.getId(), user);
           System.out.println(user.getEmail());
//           return ResponseEntity.status(HttpStatus.CREATED)
//                   .body(user);
           return new ResponseEntity<>(user,HttpStatus.OK);
       }
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        //body("user already present") we should always send object in response not a String so that we can get more information
    }

    @PutMapping
   public ResponseEntity<User> updateUser(@RequestBody User user)
   {
       if(userDb.containsKey(user.getId())) {
           userDb.put(user.getId(), user);

//           return new ResponseEntity<>(user,HttpStatus.OK);
           return ResponseEntity.ok(user);
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id)
   {
       if(userDb.containsKey(id)) {
           userDb.remove(id);
           return new ResponseEntity<>(userDb.get(id),HttpStatus.OK);
       }

       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
   }

   @GetMapping
    public List<User> getUsers()
   {
       return new ArrayList<>(userDb.values());
   }

}
