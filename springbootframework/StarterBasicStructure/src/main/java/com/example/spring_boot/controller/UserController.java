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

  //@GetMapping({"/user","/user/{id}"}) if you want to map two different urls to a single method

   @GetMapping("/{userId}")
   public ResponseEntity<User> getUser(@PathVariable("userId") int id)
   {
       if(userDb.containsKey(id)) {
           return ResponseEntity.ok(userDb.get(id));
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
   }

   //Multiple Path Variables
    @GetMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<User> getUserOrder(
            @PathVariable("userId") int id,
            @PathVariable("orderId") int order)
    {
        System.out.println("ORDER ID: "+order);
        if(userDb.containsKey(id)) {
            return ResponseEntity.ok(userDb.get(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    //@PathVariable(value="userId",defaultValue=1,required=false) if we want a path variable to be optional we can also provide default value

    //Dynamic URLs
    /*
    /user/search?keyword=yoga
    /user/2
     */

    // /search?name=Bob
    // /search?name=Bob&email=Bob@gmail.com
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam String name,
    @RequestParam (required = false,defaultValue = "bob")String email
    )
    {
        System.out.println(name);
        List<User> users = userDb.values().stream()
                .filter(u->u.getName().equalsIgnoreCase(name))
                .filter(u->u.getEmail().equalsIgnoreCase(email))
                .toList();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/info/{id}")
    public String getInfo(
            @PathVariable int id,
            @RequestParam String name,
            @RequestHeader("User-Agent") String userAgent)
    {
        return "User Agent: "+userAgent
                +" : "+id
                +" : "+name;
    }
}
