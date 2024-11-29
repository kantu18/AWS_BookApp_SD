package com.example.demo.Contoller;

import com.example.demo.Tempstore.OTPStorage;
import com.example.demo.service.EmailService;
import com.example.demo.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Verify")
public class OTPController {
    @Autowired
    private OtpService otpService;

    @Autowired
    private EmailService emailService;

    @PostMapping()
    public void generateAndSendOTP(@RequestParam("email") String email){
        if(email.length()==0){
            System.out.println("null");
        }
        String otp = otpService.generateOTP();
        System.out.println(otp);
        emailService.sendOtpEmail(email,otp);
        OTPStorage.storeOtp(email,otp);
    }
}
