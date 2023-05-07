package com.meds.service;

import com.meds.model.User;
import com.meds.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        try{
            return userRepository.findAll();
        } catch(Exception e){
          throw new RuntimeException("there is error in  get all users");
        }

    }

    public User getSpecificUser(long id) {
        return userRepository.findById(id).orElseThrow(null);
    }

    public List<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public void addUser(User user) {
        try{
            userRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException("there is error in add user");
        }

    }

    public void updateUser(User user) {
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
