package com.meds.cotroller;

import com.meds.model.Admin;
import com.meds.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminService userService;

    @GetMapping("/getAllUsers")
    public List<Admin> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getSpecificUser/{id}")
    public Admin getSpecificUser(@PathVariable long id) {

        return userService.getSpecificUser(id);

    }

    @GetMapping("/getUserByName")
    public List<Admin> getUserByName(@RequestParam String name) {

        return userService.getUserByName(name);

    }

    @PostMapping("/createUser")
    public ResponseEntity<Admin> addUser(@Valid @RequestBody Admin newUser) {
        userService.addUser(newUser);
        return new ResponseEntity<Admin>(newUser, HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<Admin> updateUser(@Valid @RequestBody Admin newUser) {
        userService.updateUser(newUser);
        return new ResponseEntity<Admin>(newUser, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "User Deleted Successfully";
    }

}


