package com.example.feedbackservice.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.feedbackservice.models.Role;
import com.example.feedbackservice.models.User;
import com.example.feedbackservice.repositories.UserRepository;
import com.example.feedbackservice.services.UserService;

@Controller
public class RegistrationController
{
    @Autowired
    private UserService userService;
    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }
    @PostMapping("/registration")
    public String adduser(User user, Model model)
    {
        try
        {
            userService.addUser(user);
            return "redirect:/login";
        }
        catch (Exception ex)
        {
            model.addAttribute("message", "User exists");
            return "registration";
        }
    }
}
