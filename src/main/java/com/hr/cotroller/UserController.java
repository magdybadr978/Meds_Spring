package com.hr.cotroller;

import com.hr.model.Users;
import com.hr.service.UserService;
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

    @GetMapping("/getUsers")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public Users getSpecificUser(@PathVariable long id) {

        return userService.getSpecificUser(id);

    }

    @GetMapping("/getUserByName")
    public List<Users> getUserByName(@RequestParam String name) {

        return userService.getUserByName(name);

    }

    @PostMapping("/createUser")
    public ResponseEntity<Users> addUser(@Valid @RequestBody Users newUser) {
        userService.addUser(newUser);
        return new ResponseEntity<Users>(newUser, HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<Users> updateUser(@Valid @RequestBody Users newUser) {
        userService.updateUser(newUser);
        return new ResponseEntity<Users>(newUser, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "User Deleted Successfully";
    }

}
