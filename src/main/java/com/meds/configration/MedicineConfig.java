package com.meds.configration;

import com.meds.errors.RecordNotFoundException;
import com.meds.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicineConfig {
    @Autowired
    private MedicineRepository medicineRepository;

    public void alreadyExists(String name){
        if(!medicineRepository.findByName(name).isEmpty()){
            throw new RuntimeException("This Medicine already exists!");
        }
    }

    public void notFound(long id){
        if(medicineRepository.findById(id).isEmpty()){
            throw  new RecordNotFoundException("not found this medicine");
        }
    }
}
