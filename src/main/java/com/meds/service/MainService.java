package com.meds.service;

import com.meds.configration.AdminAuth;
import com.meds.errors.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public abstract class MainService<C, I>{

    @Autowired
    private AdminAuth adminAuth;

    private final JpaRepository<C, I> repository;
    public MainService(JpaRepository<C, I> repository){
        this.repository = repository;
    }

    public C getRecordById(I id) {
        return repository.findById(id).orElseThrow(
                () -> new RecordNotFoundException("This Record Not Found")
        );
    }

    public List<C> getAllRecord() {
        return repository.findAll();
    }

    public void insertRecord(C newRecord, String name, long adminId){
        adminAuth.adminAuthorization(adminId);
        alreadyExists(name);
        repository.save(newRecord);
    }

    public void updateRecord(C record, long recordId, long adminId){
        adminAuth.adminAuthorization(adminId);
        notFound(recordId);
        repository.save(record);
    }

    public void deleteRecord(long adminId, I recordId){
        adminAuth.adminAuthorization(adminId);
        notFound((Long) recordId);
        repository.deleteById(recordId);
    }


    // Abstraction methods
    // will be implemented with every one service
    // because every one different each other in repository
    public abstract void alreadyExists(String name);
    public abstract void notFound(long id);

}
