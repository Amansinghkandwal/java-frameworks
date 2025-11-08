package com.example.spring_boot.controller;


import com.example.spring_boot.model.User;
import com.example.spring_boot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/*
  Response Entity -> we need to improve the api responses to tell the correct status
  HTTP response + Status Code
 */




@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService = new UserService();



    @PostMapping
    //we are doing a post request -> request->(requestHeader , requestBody)
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User createdUser= userService.createUser(user);
        if(createdUser==null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping
   public ResponseEntity<User> updateUser(@RequestBody User user)
   {
       User updated = userService.updateUser(user);
       if(updated==null)
       {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }

       return ResponseEntity.ok(user);
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id)
   {
       boolean isDeleted = userService.deleteUser(id);
       if(isDeleted)
       {
           return ResponseEntity.noContent().build();
       }

       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
   }

   @GetMapping
    public List<User> getUsers()
   {
      return userService.getAllUsers();
   }

  //@GetMapping({"/user","/user/{id}"}) if you want to map two different urls to a single method

   @GetMapping("/{userId}")
   public ResponseEntity<User> getUser(@PathVariable("userId") int id)
   {
       User user =userService.getUserById(id);

       if(user!=null) {
           return ResponseEntity.ok(user);
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
   }

   //Multiple Path Variables
    @GetMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<User> getUserOrder(
            @PathVariable("userId") int id,
            @PathVariable("orderId") int order)
    {
        User user =userService.getUserById(id);

        if(user!=null) {
            return ResponseEntity.ok(user);
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

        return ResponseEntity.ok(userService.searchUsers(name,email));
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
