package com.blog.blogspring.controller;

import com.blog.blogspring.security.details.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String getProfile(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("userName", userDetails.getUsername());
        model.addAttribute("userId", userDetails.getUserId());
        return "profile_page";
    }
}
