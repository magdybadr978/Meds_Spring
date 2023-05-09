package com.meds.configration;

import com.meds.errors.ForbiddenException;
import com.meds.errors.RecordNotFoundException;
import com.meds.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminAuthorization extends Authentication{

    @Autowired
    private UserRepository userRepository;

    public void isAdmin(long id){
        this.isExists(id);
        userRepository.isAdmin(id).orElseThrow(
                ()-> new ForbiddenException("Sorry, this user forbidden for this option")
        );
    }

}
