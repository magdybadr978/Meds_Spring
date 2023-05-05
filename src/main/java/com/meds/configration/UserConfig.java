package com.meds.configration;

import com.meds.errors.ForbiddenException;
import com.meds.errors.RecordNotFoundException;
import com.meds.repository.AdminRepository;
import com.meds.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConfig {

    @Autowired
    private AdminRepository adminRepository;

    public void isExists(long id){
        adminRepository.userIsExists(id).orElseThrow(
                ()-> new RecordNotFoundException("Not found this user")
        );

    }
    public void isAdmin(long id){
        adminRepository.isAdmin(id).orElseThrow(
                ()-> new ForbiddenException("Sorry, this user forbidden for this option")
        );
    }

}
