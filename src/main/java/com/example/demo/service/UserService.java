package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void addUser(User user){
        userRepo.save(user);
    }
    public boolean checkUserName(User user){
        if(userRepo.existsById(user.getUserName())){
            return true;
        }else {
            return false;
        }
    }
    private String userUserName;
    public boolean checkPassword(User user){
        Optional<User> byId = userRepo.findById(user.getUserName());
        System.out.println(byId.get().getPassword());
        System.out.println(user.getPassword());
        if(byId.get().getPassword().equals(user.getPassword())){
            userUserName = byId.get().getUserName();
            return true;
        }else{
            return false;
        }
    }
    public User getUser(){
        Optional<User> byId = userRepo.findById(userUserName);
        return byId.get();
    }
    public boolean deleteUser(User user){
        try {
            userRepo.delete(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
