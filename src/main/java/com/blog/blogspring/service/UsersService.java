package com.blog.blogspring.service;

import com.blog.blogspring.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();
}
