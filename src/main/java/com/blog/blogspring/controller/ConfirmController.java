package com.blog.blogspring.controller;

import com.blog.blogspring.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ConfirmController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/confirm/{code}")
    public String confirmUser(@PathVariable("code") String code) {

        boolean confirmed = signUpService.confirmByGmail(code);

        if (!confirmed) {
            return "redirect:/signUp?error";
        }
        
        return "redirect:/signIn";
    }
}
