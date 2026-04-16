package com.form.services;

import com.form.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

//    @Autowired
//    private UserRepo userRepo;

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject , String body){

        SimpleMailMessage msg=new SimpleMailMessage();
        msg.setFrom("supriyasingh9204@gmail.com");
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(body);

        try {
            mailSender.send(msg);
            System.out.println("Mail sent successfully!");
        } catch (Exception e) {
            System.out.println("Mail sending failed: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Preparing to send email to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}
