package com.example.NerdWarehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl{
    @Autowired
    private final JavaMailSender mailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    public void sendSimpleEmail(
            String toEmail,
            String subject,
            String body)
    {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("nerdwarehouse@gmail.com");
            message.setTo(toEmail);
            message.setText(body);
            message.setSubject(subject);
            mailSender.send(message);

        }
    }



