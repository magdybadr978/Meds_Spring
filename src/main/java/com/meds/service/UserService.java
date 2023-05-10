package com.meds.service;

import com.meds.errors.RecordNotFoundException;
import com.meds.model.User;
import com.meds.repository.UserRepository;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends MainService<User, Long> {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public <T> void checksBeforeInsert(T check) {
        User user = (User) check;
        alreadyExists(user.getEmail());
    }

    @Override
    public <T> void checksBeforeUpdate(T check) {
        User user = (User) check;
        notFound(user.getId());
    }

    @Override
    public <T> void checksBeforeDelete(T check) {
        notFound((long) check);
    }

    @Override
    public <T> User prepareRecordForUpdate(User userFromBody) {
        return userFromBody;
    }

    public void login(User user){

        if(!userRepository.existsUserByEmail(user.getEmail())){
            throw new RecordNotFoundException("this email not fuound");
        };
        User newUser = userRepository.findUserByEmail(user.getEmail());
        if (!user.getPassword().equals(newUser.getPassword())){
            throw new RuntimeException("this password incorrect! ");
        }
    }

    public void notFound(long id) {
        if(!userRepository.existsUserById(id)){
            throw new RecordNotFoundException("This User not found");
        }
    }

    public void alreadyExists(String email) {
        if(userRepository.existsUserByEmail(email)){
            throw new RuntimeException("the email of this user already exists");
        };
    }
}



