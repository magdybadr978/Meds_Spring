package com.meds.cotroller;


import com.meds.configration.AdminAuthorization;
import com.meds.configration.UserAuthorization;
import com.meds.model.Request;
import com.meds.repository.RequestRepository;
import com.meds.service.RequestSerivce;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("requests")
public class RequestController {

    @Autowired
    private RequestSerivce requsetSerivce;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private AdminAuthorization adminAuthorization;
    @Autowired
    private UserAuthorization userAuthorization;

    @GetMapping("all")
    public List<Request> getAllRequest(@RequestHeader("adminID") long adminID) {
        adminAuthorization.isAdmin(adminID);
        return requsetSerivce.getAllRecord();
    }

    @GetMapping("{id}")
    public Request getRequestById(
            @PathVariable long id,
            @RequestHeader("adminID") long adminID) {
        adminAuthorization.isAdmin(adminID);
        return requsetSerivce.getRecordById(id);
    }

    @PostMapping("insert")
    public ResponseEntity<Request> insertRequest(
            @RequestBody Request request,
            @RequestHeader("userID") long userID) {
        userAuthorization.isExists(userID);
        requsetSerivce.insertRecord(request);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }


    @PutMapping("update")
    public ResponseEntity<String> updateRequest(
            @RequestBody Request request,
            @RequestHeader("adminID") long adminID) {
        adminAuthorization.isAdmin(adminID);
        requsetSerivce.updateRecord(request);
        return new ResponseEntity<>("Request updated successfully", HttpStatus.OK);
    }


    @DeleteMapping("delete/{requestID}")
    public ResponseEntity<String> deleteRequest(
            @PathVariable long requestID,
            @RequestHeader("adminID") long adminID){
        adminAuthorization.isAdmin(adminID);
        requsetSerivce.deleteRecord(requestID);
        return new ResponseEntity<>("Request deleted successfully", HttpStatus.OK);
    }

}