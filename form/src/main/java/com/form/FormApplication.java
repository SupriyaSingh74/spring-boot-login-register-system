package com.form;

import com.form.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormApplication {

    @Autowired
    private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(FormApplication.class, args);
	}

//    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application started, sending test mail...");
        emailService.sendEmail("supriyasingh9204@gmail.com", "Test Email", "Hello world");
    }

}
