package com.meds.cotroller;

import com.meds.configration.AdminAuthorization;
import com.meds.model.User;
import com.meds.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminAuthorization adminAuthorization;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(@RequestHeader("adminID") long adminID) {
        adminAuthorization.isAdmin(adminID);
        return userService.getAllRecord();
    }

    @GetMapping("{id}")
    public User getSpecificUser(@PathVariable long id, @RequestHeader("adminID") long adminID) {
        adminAuthorization.isAdmin(adminID);
        return userService.getRecordById(id);
    }

    @PostMapping("/insert")
    public ResponseEntity<User> addUser(
            @RequestBody @Valid User newUser,
            @RequestHeader("adminID") long adminID) {
        adminAuthorization.isAdmin(adminID);
        userService.insertRecord(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PutMapping("/update/{userID}")
    public ResponseEntity<String> updateUser(
            @Valid @RequestBody User newUser,
            @PathVariable long userID,
            @RequestHeader("adminID") long adminID) {
        adminAuthorization.isAdmin(adminID);
        userService.updateRecord(newUser, userID);
        return new ResponseEntity<>("user updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(
            @PathVariable long userId,
            @RequestHeader("adminID") long adminId) {
        adminAuthorization.isAdmin(adminId);
        userService.deleteRecord(userId);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

}


