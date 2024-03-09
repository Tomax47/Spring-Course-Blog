package com.blog.blogspring.service;

import com.blog.blogspring.dto.UserDto;
import com.blog.blogspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import static com.blog.blogspring.dto.UserDto.usersList;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<UserDto> getAllUsers() {
        return usersList(userRepo.findAll());
    }
}
