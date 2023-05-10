package com.meds.service;

import com.meds.errors.RecordNotFoundException;
import com.meds.model.Medicine;
import com.meds.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MedicineService extends MainService<Medicine, Long> {

    @Autowired
    private MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository){
        super(medicineRepository);
    }

    @Override
    public <T> void checksBeforeInsert(T check) {
        Medicine medicine = (Medicine) check;
        alreadyExists(medicine.getName());
    }

    @Override
    public <T> void checksBeforeUpdate(T check) {
        Medicine medicine = (Medicine) check;
        notFound(medicine.getId());
    }

    @Override
    public <T> void checksBeforeDelete(T check){
        notFound((long) check);
    }

    @Override
    public <T> Medicine prepareRecordForUpdate(Medicine medicineFromBody) {
        return medicineFromBody;
    }

    public void notFound(long id) {
        if(!medicineRepository.existsMedicineById(id)){
            throw new RecordNotFoundException("this medicine not found");
        };
    }


    public void alreadyExists(String name) {
        if(medicineRepository.existsMedicineByName(name)){
            throw new RuntimeException("this medicine already exists");
        };
    }

    public List<Medicine> filterMedicine(String name){
        return medicineRepository.filterMedicine(name).orElseThrow(
                () -> new RecordNotFoundException("This Record Not Found")
        );
    }








}
