package com.meds.cotroller;

import com.meds.model.User;
import com.meds.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
//
//    @GetMapping("/getAllUsers")
//    public List<User> getAllUsers() {
//        return userService.getAllRecord();
//    }
//
//    @GetMapping("/getSpecificUser/{id}")
//    public User getSpecificUser(@PathVariable long id) {
//
//        return userService.getSpecificUser(id);
//
//    }
//
//    @GetMapping("/getUserByName")
//    public List<User> getUserByName(@RequestParam String name) {
//
//        return userService.getUserByName(name);
//
//    }
//
//    @PostMapping("/createUser")
//    public ResponseEntity<User> addUser(@Valid @RequestBody User newUser) {
//        userService.addUser(newUser);
//        return new ResponseEntity<User>(newUser, HttpStatus.OK);
//    }
//
//    @PutMapping("/updateUser")
//    public ResponseEntity<User> updateUser(@Valid @RequestBody User newUser) {
//        userService.updateUser(newUser);
//        return new ResponseEntity<User>(newUser, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/deleteUser/{id}")
//    public String deleteUser(@PathVariable long id) {
//        userService.deleteUser(id);
//        return "User Deleted Successfully";
//    }
//
}


