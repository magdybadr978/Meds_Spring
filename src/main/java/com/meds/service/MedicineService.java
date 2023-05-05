package com.meds.service;

import com.meds.configration.MedicineConfig;
import com.meds.configration.UserConfig;
import com.meds.errors.RecordNotFoundException;
import com.meds.errors.ForbiddenException;
import com.meds.model.Medicine;
import com.meds.repository.AdminRepository;
import com.meds.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService{

    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserConfig userConfig;

    @Autowired
    private MedicineConfig medicineConfig;


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
        userConfig.isExists(id);
        userConfig.isAdmin(id);
        medicineConfig.alreadyExists(medicine.getName());

        medicineRepository.save(medicine);
    }

    public void updateMedicine(Medicine medicine, long adminID, long medicineID){
        userConfig.isExists(adminID);
        userConfig.isAdmin(adminID);
        medicineConfig.notFound(medicineID);

        // to update medicine with old id
        medicine.setId(medicineID);
        medicineRepository.save(medicine);
    }

    public void deleteMedicine(long adminID, long medicineID){
        userConfig.isExists(adminID);
        userConfig.isAdmin(adminID);
        medicineConfig.notFound(medicineID);

        medicineRepository.deleteById(medicineID);
    }




}
