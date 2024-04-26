package com.blog.blogspring.service;

public interface MailService {
    void sendEmailForConfirmation(String email, String code);
}
