package com.blog.blogspring.service;

import com.blog.blogspring.dto.UserForm;
import com.blog.blogspring.model.Role;
import com.blog.blogspring.model.User;
import com.blog.blogspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component // This class is responsible for business logic
public class SignUpServiceImpl implements SignUpService {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepo usersRepository;
    @Override
    public void addUser(UserForm userForm) {
        User user = User.builder()
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .firstName(userForm.getFirstname())
                .lastName(userForm.getLastname())
                .confirmed("CONFIRMED")
                .role(Role.USER)
                .build();
        usersRepository.save(user);
    }
}
