package ru.geekbrains.lesson.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.geekbrains.lesson.store.services.UserService;

@Controller
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    public String logout(){
        return "redirect:/";
    }
}
