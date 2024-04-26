package com.blog.blogspring.service;

import com.blog.blogspring.dto.UserDto;
import com.blog.blogspring.dto.UserForm;
import com.blog.blogspring.model.Role;
import com.blog.blogspring.model.State;
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
    public UserDto addUser(UserForm userForm) {
        User user = User.builder()
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .firstName(userForm.getFirstname())
                .lastName(userForm.getLastname())
                .confirmed(String.valueOf(State.NOT_CONFIRMED))
                .phoneNumber(userForm.getPhoneNumber())
                .role(Role.USER)
                .build();

        try {
            usersRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return UserDto.from(user);
    }

    @Override
    public boolean confirmAccount(String email) {
        User user = usersRepository.findByEmail(email).get();

        System.out.println("USER "+ user.getEmail());
        if (user != null) {
            user.setConfirmed("CONFIRMED");
            usersRepository.save(user);
            return true;
        }

        return false;
    }
}
