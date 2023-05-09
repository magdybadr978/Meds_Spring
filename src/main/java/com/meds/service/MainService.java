package com.meds.service;

import com.meds.configration.AdminAuth;
import com.meds.errors.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public abstract class MainService<DTClass, DTId> {

    @Autowired
    private AdminAuth adminAuth;

    private final JpaRepository<DTClass, DTId> repository;

    public MainService(JpaRepository<DTClass, DTId> repository) {
        this.repository = repository;
    }

    public DTClass getRecordById(DTId id) {
        return repository.findById(id).orElseThrow(
                () -> new RecordNotFoundException("This Record Not Found")
        );
    }

    public List<DTClass> getAllRecord() {
        return repository.findAll();
    }



    public void insertRecord(DTClass newRecord, long adminId) {
        adminAuth.adminAuthorization(adminId);
        checksBeforeInsert(newRecord);
        repository.save(newRecord);
    }

    public void updateRecord(DTClass record, long recordId, long adminId) {
        adminAuth.adminAuthorization(adminId);
        checksBeforeUpdate(recordId);
        DTClass preparedRecord = prepareRecordForUpdate(record, recordId);
        repository.save(preparedRecord);
    }

    public void deleteRecord(long adminId, DTId recordId) {
        adminAuth.adminAuthorization(adminId);
        checksBeforeDelete(recordId);
        repository.deleteById(recordId);
    }


    /*
     Abstraction methods
     will be implemented with every one service
     because every one different each other in repository
    */
    public abstract <T> void checksBeforeInsert(T check);
    public abstract <T> void checksBeforeUpdate(T check);

    public abstract <T> void checksBeforeDelete(T check);
    public abstract <T> DTClass prepareRecordForUpdate(DTClass record, T any);

}
