package com.form.controller;

import com.form.entities.User;
import com.form.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.form.dao.UserRepo;


@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EmailService emailService;

    //home page
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    //register page
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    //save user
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute User user, BindingResult result, Model model){

        System.out.println("POST /register called for email: " + user.getEmail());

        if (result.hasErrors()) {
            return "register";
        }else {
            userRepo.save(user);
            System.out.println("Sending mail to: " + user.getEmail());
            try {
                emailService.sendEmail(
                        user.getEmail(),
                        "Registration Successful",
                        "Hello " + user.getUserName() + ", your registration was successful."
                );
            } catch (Exception e) {
                System.out.println("Email sending failed: " + e.getMessage());
            }
        }

        model.addAttribute("message", "Registration Successfully!!... , Check your email.");
        return "success";
    }

    //login page
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    //login page logic

    @PostMapping("/login")
    public  String login(@RequestParam String email,
                         @RequestParam String password,
                         Model model){
        // DB me check karo
        User user = userRepo.findByEmail(email);

        if(user!=null && user.getPassword().equals(password)){
            //Login Success
            model.addAttribute("name" , user.getUserName());
            return "home";
        }
        //Login failed
        model.addAttribute("error","Invalid username and password");
        return "login";
    }

}
