package com.somsakKaeworasan.marauders.controller;

import com.somsakKaeworasan.marauders.model.User;
import com.somsakKaeworasan.marauders.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity getAll(){

        try {
            var res = userService.getAll();
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user){

        try {
            var res = userService.register(user);
            System.out.println(res);
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user){

        try {
            var res = userService.login(user);
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }
}
