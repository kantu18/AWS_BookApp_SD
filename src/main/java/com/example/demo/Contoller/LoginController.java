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

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    AdminService adminService;

    @GetMapping("/admin-Login")
    public String adminLogin(Model model){
        model.addAttribute("adminLogin",new Admin());
        return "adminLogin";
    }
    @PostMapping("/adminLogin")
    public String adminChecker(@ModelAttribute Admin admin){
        if(adminService.checkUserName(admin)){
            if(adminService.checkPassword(admin)){
                return "redirect:/login/AdminDetails";
            }{
                return "wrongPasswordAdmin";
            }
        }else{
            return "noAdmin";
        }
    }
    @GetMapping("/AdminDetails")
    public String adminPage(){
        return "home";
    }


    @Autowired
    private UserService userService;

    @GetMapping("/User-Login")
    public String userLogin(Model model){
        model.addAttribute("userLogin",new User());
        return "userLogin";
    }
    @PostMapping("/userLogin")
    public String userChecker(@ModelAttribute User user){
        if(userService.checkUserName(user)){
            if(userService.checkPassword(user)){
                return "redirect:/login/UserDetails";
            }{
                return "wrongPasswordUser";
            }
        }else{
            return "noUser";
        }
    }
    @GetMapping("/UserDetails")
    public String userDetailsShow(Model model){
        model.addAttribute("details",userService.getUser());
        return "home";
    }
}
