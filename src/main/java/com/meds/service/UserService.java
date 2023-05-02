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
        return userRepository.findAll();
    }

    public Users getSpecificUser(long id) {
        return userRepository.findById(id).orElseThrow(null);
    }

    public List<Users> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public void addUser(Users user) {
        userRepository.save(user);
    }

    public void updateUser(Users user) {
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

}
