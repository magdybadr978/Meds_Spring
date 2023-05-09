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

    }

    @Override
    public <T> void checksBeforeUpdate(T check) {

    }

    @Override
    public <T> void checksBeforeDelete(T check) {

    }

    @Override
    public <T> User prepareRecordForUpdate(User record, T any) {
        return null;
    }

    public void notFound(long id) {
        if(!userRepository.existsUserById(id)){
            throw new RecordNotFoundException("This User not found");
        }
    }
}
//
//    public List<User> getAllUsers() {
//        try{
//            return userRepository.findAll();
//        } catch(Exception e){
//          throw new RuntimeException("there is error in  get all users");
//        }
//
//    }
//
//    public User getSpecificUser(long id) {
//        return userRepository.findById(id).orElseThrow(null);
//    }
//
//    public List<User> getUserByName(String name) {
//        return userRepository.findByName(name);
//    }
//
//    public void addUser(User user) {
//        try{
//            userRepository.save(user);
//        }catch (Exception e){
//            throw new RuntimeException("there is error in add user");
//        }
//
//    }
//
//    public void updateUser(User user) {
//        try{
//            userRepository.save(user);
//        }catch (Exception e){
//            throw new RuntimeException("there is error in update user");
//        }
//
//    }
//
//
//    public void deleteUser(long id) {
//        try{
//            userRepository.deleteById(id);
//        }catch (Exception e){
//            throw new RuntimeException("there is error in delete user");
//        }
//
//    }
