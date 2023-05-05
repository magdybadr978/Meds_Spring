package com.meds.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class Service<C, I> {

    private JpaRepository<C, I> repository;

    public List<C> getAllMedicines(){
        return repository.findAll();
    }
}
