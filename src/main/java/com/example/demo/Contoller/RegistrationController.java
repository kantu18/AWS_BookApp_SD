package com.example.demo.Contoller;

import com.raj.library.Service.AdminService;
import com.raj.library.Service.UserService;
import com.raj.library.entity.Admin;
import com.raj.library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/addAdmin")
    public String  addAdmin(@ModelAttribute Admin admin){
        adminService.addAdmin(admin);
        return "SuccessAdmin";
    }
    @GetMapping("/add-Admin")
    public String getMethodForAddAdmin(Model model){
        model.addAttribute("admin",new Admin());
        return "addAdmin";
    }

    @Autowired
    private UserService userService;

    @GetMapping("/add-User")
    public String addUser(Model model){
        model.addAttribute("user",new User());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String postUser(@ModelAttribute User user){
        userService.addUser(user);
        return "SuccessUser";
    }
}
