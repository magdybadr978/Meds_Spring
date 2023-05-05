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
public class MedicineService{

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


    public void insertMedicine(Medicine medicine, long adminID){
        adminRepository.userIsExists(adminID).orElseThrow(
                ()-> new RecordNotFoundException("Not found this user")
        );

        adminRepository.isAuth(adminID).orElseThrow(
                ()-> new ForbiddenException("Sorry, this user forbidden for this option")
        );

        if(!medicineRepository.findByName(medicine.getName()).isEmpty()){
            throw new RuntimeException("This Medicine already exists!");
        }
        medicineRepository.save(medicine);
    }

    public void updateMedicine(Medicine medicine, long adminID, long medicineID){
        adminRepository.userIsExists(adminID).orElseThrow(
                ()-> new RecordNotFoundException("Not found this user")
        );

        adminRepository.isAuth(adminID).orElseThrow(
                ()-> new ForbiddenException("Sorry, this user forbidden for this option")
        );

        if(medicineRepository.findById(medicineID).isEmpty()){
            throw  new RecordNotFoundException("not found this medicine");
        }
        medicine.setId(medicineID);
        medicineRepository.save(medicine);
    }

    public void deleteMedicine(long adminID, long medicineID){
        adminRepository.userIsExists(adminID).orElseThrow(
                ()-> new RecordNotFoundException("Not found this user")
        );

        adminRepository.isAuth(adminID).orElseThrow(
                ()-> new ForbiddenException("Sorry, this user forbidden for this option")
        );

        if(medicineRepository.findById(medicineID).isEmpty()){
            throw  new RecordNotFoundException("not found this medicine");
        }
        medicineRepository.deleteById(medicineID);
    }




}
