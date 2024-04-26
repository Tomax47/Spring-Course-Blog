package com.blog.blogspring.controller;

import com.blog.blogspring.dto.UserDto;
import com.blog.blogspring.dto.UserForm;
import com.blog.blogspring.service.SignUpService;
import com.blog.blogspring.service.SmsService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// The annotation tells Maven that this is a controller
@Controller
public class SignUpController {
    @Autowired
    SignUpService signUpService;

    @Autowired
    SmsService smsService;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "sign_up_page";
    }

    @PostMapping("/signUp")
    public String signUp(UserForm form) {

        UserDto user = signUpService.addUser(form);

        if (form.getPhoneNumber().length() > 1) {
            return "redirect:/sms/confirm?phoneNumber=" + user.getPhoneNumber() + "&email=" + user.getEmail();
        }

        return "redirect:/signIn";
    }

    @GetMapping("/sms/confirm")
    public String getAccountConfirmationPage(Model model,
                                             @RequestParam("phoneNumber") String phoneNumber,
                                             @RequestParam("email") String email) {
        String vCode = smsService.sendSms(phoneNumber, "ver");
        model.addAttribute("vCode", vCode);
        model.addAttribute("email", email);

        return "account_confirmation";
    }

    @PostMapping("/sms/confirm")
    public String confirmAccount(Model model, @RequestParam("vCode") String vCode,
                                 @RequestParam("code") String code,
                                 @RequestParam("email") String email) {

        System.out.println("CODE : "+code+"\nV-CODE : "+vCode);
        System.out.println("V-CODE = CODE ? "+vCode.equals(code));
        if (vCode.trim().equals(code.trim())) {
            boolean b = signUpService.confirmAccount(email.trim());

            System.out.println("CONFIRMED? -> "+b);
        }

        return "redirect:/signIn";
    }
}
