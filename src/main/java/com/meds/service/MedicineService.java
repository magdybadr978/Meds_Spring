package com.meds.service;

import com.meds.errors.RecordNotFoundException;
import com.meds.model.Medicine;
import com.meds.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService extends MainService<Medicine, Long> {

    @Autowired
    private MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository){
        super(medicineRepository);
    }

    @Override
    public void alreadyExists(String name) {
        if(medicineRepository.existsMedicineByName(name)){
            throw new RuntimeException("this medicine already exists");
        };
    }

    @Override
    public void notFound(long id) {
        if(!medicineRepository.existsMedicineById(id)){
            throw new RuntimeException("this medicine not found");
        };
    }


    public List<Medicine> filterMedicine(String name){
        return medicineRepository.filterMedicine(name).orElseThrow(
                () -> new RecordNotFoundException("This Record Not Found")
        );
    }








}
