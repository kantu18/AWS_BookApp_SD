package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    AdminRepo adminRepo;


    public void addAdmin(Admin admin){
        adminRepo.save(admin);
    }

    public boolean checkUserName(Admin admin){
        if(adminRepo.existsById(admin.getUserName())){
            return true;
        }else{
            return false;
        }
    }
    private String adminUserName;
    public boolean checkPassword(Admin admin){
        Optional<Admin> byId = adminRepo.findById(admin.getUserName());
        System.out.println(byId.get().getPassword());
        System.out.println(admin.getPassword());
        if(byId.get().getPassword().equals(admin.getPassword())){
            adminUserName = byId.get().getUserName();
            return true;
        }else{
            return false;
        }
    }
    public Admin getAdmin(){
        Optional<Admin> byId = adminRepo.findById(adminUserName);
        return byId.get();
    }
}
