package com.meds.service;

import com.meds.errors.RecordNotFoundException;
import com.meds.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public class MainService<C, I> {


    public C getRecordById(JpaRepository<C, I> repository, I id) {
        return repository.findById(id).orElseThrow(
                () -> new RecordNotFoundException("This Record Not Found")
        );
    }

    public List<C> getAllRecord(JpaRepository<C, I> repository) {
        return repository.findAll();
    }
}
