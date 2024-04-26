package com.blog.blogspring.service;

public interface SmsService {
    String sendSms(String phone, String text);
}
