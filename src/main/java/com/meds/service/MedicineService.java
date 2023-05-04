package com.meds.service;

import com.meds.errors.RecordNotFoundException;
import com.meds.model.Medicine;
import com.meds.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    public List<Medicine> getAllMedicines(){
        return medicineRepository.findAll();
    }

    public Medicine getMedicineById(long id){
        return medicineRepository.findById(id).orElseThrow(
                ()->new RecordNotFoundException("This Medicine Not Found")
        );
    }

    public List<Medicine> filterMedicine(String name){
        return medicineRepository.filterMedicine(name).orElseThrow(
                () -> new RecordNotFoundException("This Medicine Not Found")
        );
    }

}
