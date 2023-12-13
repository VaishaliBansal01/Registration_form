package com.springboot.login.signup.controller;

import com.springboot.login.signup.entity.User;
import com.springboot.login.signup.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/")
    public String home(Model model)
    {
     return  "index";
    }

    /*@PostMapping("/register")
    public String showRegistrationForm(@ModelAttribute User user, Model model)
     {
         *//*ModelAndView modelAndView = new ModelAndView();
         modelAndView.setViewName("signup_form");*//*
         //return modelAndView;
         model.addAttribute("name",user.getName());
         model.addAttribute("email",user.getEmail());
         model.addAttribute("password",user.getPassword());
         userRepo.save(user);
         return "registration_form";
    }*/
   @GetMapping("/registration_form")
    public String showRegistrationForm(Model model)
    {
      User user = new User();
      model.addAttribute("user", user);
      return "registration_form";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user, Model model)
    {
        BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
        String encryptedPassword = crypt.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        model.addAttribute("user", user);
        userRepo.save(user);
        return "display_form";
    }
   @GetMapping("/login")
    public String showLoginForm(@ModelAttribute User user, Model model)
    {
       /* User user1 = userRepo.findBYEmail(user.getEmail());
        if(user1!=null)*/
       return "login_form";
       /* else
            return "registration_form";*/
    }
    @PostMapping("/login_f")
    public String login(@ModelAttribute User user, Model model)
    {
        //BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
        User user1 = userRepo.findByEmail(user.getEmail());
       if(user1!= null )
           return "success";

       else
           return "login_form";
    }

}
