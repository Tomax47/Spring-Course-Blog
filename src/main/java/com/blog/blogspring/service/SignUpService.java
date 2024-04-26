package com.blog.blogspring.service;

import com.blog.blogspring.dto.UserDto;
import com.blog.blogspring.dto.UserForm;

public interface SignUpService {
    public UserDto addUser(UserForm form);
    public boolean confirmAccount(String email);
    public boolean confirmByGmail(String confirmationCode);
}
