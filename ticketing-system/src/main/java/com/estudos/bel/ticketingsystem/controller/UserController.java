package com.estudos.bel.ticketingsystem.controller;

import com.estudos.bel.ticketingsystem.entity.User;
import com.estudos.bel.ticketingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return userService.delete(id);
    }
    @PutMapping("/alter")
    public ResponseEntity<?> alter(@RequestBody User user){
        return userService.alter(user);
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        return userService.register(user);
    }
    @GetMapping("/list")

    public Iterable<User> list(){
        return userService.list();
    }

    @GetMapping("/")
    public String route(){
        return "";
    }
}
