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

import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

@Component // This class is responsible for business logic
public class SignUpServiceImpl implements SignUpService {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepo usersRepository;

    @Autowired
    private MailService mailService;

    @Override
    public UserDto addUser(UserForm userForm) {

        String confirmationCode = String.valueOf((new Random().nextInt(1000, 9999)));
        User user = User.builder()
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .firstName(userForm.getFirstname())
                .lastName(userForm.getLastname())
                .confirmed(String.valueOf(State.NOT_CONFIRMED))
                .phoneNumber(userForm.getPhoneNumber())
                .role(Role.USER)
                .confirmationCode(confirmationCode)
                .build();

        // Email verification
        if (user.getPhoneNumber() == null) {
            // No number has been provided, sending an email verification link
            mailService.sendEmailForConfirmation(user.getEmail(), user.getConfirmationCode());
        }

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

    @Override
    public boolean confirmByGmail(String confirmationCode) {
        User user = usersRepository.findByConfirmationCode(confirmationCode).get();

        System.out.println("USER "+ user.getEmail());
        if (user != null) {
            user.setConfirmed("CONFIRMED");
            usersRepository.save(user);
            return true;
        }

        return false;
    }
}
