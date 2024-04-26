package com.blog.blogspring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Slf4j
@Component
public class SmsServiceImpl implements SmsService {

    @Value("${sms.ru.url}")
    private String smsUrl;

    @Value("${sms.ru.api_id}")
    private String apiId;

    @Value("${sms.ru.msg}")
    private String messageUrl;

    @Value("${sms.ru.json}")
    private String messageJson;
    private RestTemplate restTemplate = new RestTemplate();
    @Override
    public String sendSms(String phone, String smsType) {

        String text = "";


        if (smsType.equals("ver")) {
            // Msg is a verification one
            text = generateVerificationCode();
        }

        String url = smsUrl + apiId + phone + messageUrl + text + messageJson;
        log.info(url);
        String result = restTemplate.getForObject(url, String.class);
        log.info(result);

        // Returning the code
        return String.valueOf(text.split(":")[1]);
    }

    private String generateVerificationCode() {
        Random rnd = new Random();
        int vCode = rnd.nextInt(1000, 9999);

        return "Here's your confirmation code : "+vCode;
    }
}
