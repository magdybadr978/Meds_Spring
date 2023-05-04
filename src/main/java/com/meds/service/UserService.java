package com.meds.service;

import com.meds.model.Users;
import com.meds.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        try{
            return userRepository.findAll();
        } catch(Exception e){
          throw new RuntimeException("there is error in  get all users");
        }

    }

    public Users getSpecificUser(long id) {
        return userRepository.findById(id).orElseThrow(null);
    }

    public List<Users> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public void addUser(Users user) {
        try{
            userRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException("there is error in add user");
        }

    }

    public void updateUser(Users user) {
        try{
            userRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException("there is error in update user");
        }

    }


    public void deleteUser(long id) {
        try{
            userRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("there is error in delete user");
        }

    }

}
