package com.blog.blogspring.controller;

import com.blog.blogspring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public String getUsersPage(Model user) {
        user.addAttribute("usersList", usersService.getAllUsers());
        return "users_page";
    }
}