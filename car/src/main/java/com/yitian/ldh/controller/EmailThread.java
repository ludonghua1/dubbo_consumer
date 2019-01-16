package com.yitian.ldh.controller;

import com.yitian.ldh.webservice.soap.UserWebService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailThread implements Runnable {
    private SimpleMailMessage mail;
    private UserWebService userWebService;

    private static JavaMailSenderImpl mailSender;

    public EmailThread(SimpleMailMessage mail) {
        this.mail = mail;
    }

    public static void setUserWebService(UserWebService userWebService) {

    }

    public void run() {
        mailSender.send(mail);
    }

    public static void setMailSender(JavaMailSenderImpl mailSender){
        EmailThread.mailSender = mailSender;
    }
}
