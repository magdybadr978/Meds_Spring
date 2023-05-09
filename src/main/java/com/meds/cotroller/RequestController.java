package com.meds.cotroller;


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

    @GetMapping("all")
    public List<Request> getAllRequest() {
        return requsetSerivce.getAllRecord();
    }

    @GetMapping("{id}")
    public Request getRequestById(@PathVariable long id) {
        return requsetSerivce.getRecordById(id);
    }

    @PostMapping("insert")
    public ResponseEntity<Request> insertRequest(
            @RequestBody Request request,
            @RequestHeader("adminID") long adminID) {
        requsetSerivce.insertRecord(request, adminID);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }


    @PutMapping("update/{requestID}")
    public ResponseEntity<String> updateRequest(
            @RequestBody Request request,
            @PathVariable long requestID,
            @RequestHeader("adminID") long adminID) {
        requsetSerivce.updateRecord(request, requestID, adminID);
        return new ResponseEntity<>("Request updated successfully", HttpStatus.OK);
    }


    @DeleteMapping("delete/{requestID}")
    public ResponseEntity<String> deleteRequest(
            @PathVariable long requestID,
            @RequestHeader("adminID") long adminID){
        requsetSerivce.deleteRecord(adminID, requestID);
        return new ResponseEntity<>("Request deleted successfully", HttpStatus.OK);
    }

}