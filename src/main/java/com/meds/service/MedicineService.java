package com.meds.service;

import com.meds.errors.RecordNotFoundException;
import com.meds.errors.ForbiddenException;
import com.meds.model.Medicine;
import com.meds.repository.AdminRepository;
import com.meds.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private AdminRepository adminRepository;

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


    public void insertMedicine(Medicine medicine, long id){
        adminRepository.userIsExists(id).orElseThrow(
                ()-> new RecordNotFoundException("Not found this user")
        );

        adminRepository.isAuth(id).orElseThrow(
                ()-> new ForbiddenException("Sorry, this user forbidden for this option")
        );

        medicineRepository.save(medicine);
    }



}
