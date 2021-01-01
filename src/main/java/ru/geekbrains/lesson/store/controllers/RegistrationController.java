package ru.geekbrains.lesson.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.lesson.store.data.UserData;
import ru.geekbrains.lesson.store.entities.User;
import ru.geekbrains.lesson.store.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public String registration(
            Model model
    ){
        model.addAttribute("userData", new UserData());
        return "registration";
    }

    @PostMapping
    public String registration(
            @Valid @ModelAttribute UserData userData,
            BindingResult  bindingResult
    ){
        if (bindingResult.hasErrors()){
            return "registration";
        }
        User user  = userService.createUser(userData);
        userService.authenticateUser(user);
        return "redirect:/";
    }

}