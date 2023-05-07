package com.meds.configration;

import com.meds.errors.ForbiddenException;
import com.meds.errors.RecordNotFoundException;
import com.meds.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminAuth {

    @Autowired
    private UserRepository userRepository;


    private void isExists(long id){
        if(!userRepository.existsById(id)){
            throw new RecordNotFoundException("this user not found");
        };
    }
    private void isAdmin(long id){
        userRepository.isAdmin(id).orElseThrow(
                ()-> new ForbiddenException("Sorry, this user forbidden for this option")
        );
    }

    public void adminAuthorization(long id){
        this.isExists(id);
        this.isAdmin(id);
    }
}
