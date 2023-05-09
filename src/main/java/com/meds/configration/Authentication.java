package com.meds.configration;

import com.meds.errors.RecordNotFoundException;
import com.meds.errors.UnauthorizedException;
import com.meds.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class Authentication {
    @Autowired
    private UserRepository userRepository;


    public void isExists(long id){
        if(!userRepository.existsById(id)){
            throw new UnauthorizedException("Sorry, this user unauthorized");
        };
    }
}
