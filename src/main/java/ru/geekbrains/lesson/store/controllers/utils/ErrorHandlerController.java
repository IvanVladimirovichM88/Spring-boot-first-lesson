package ru.geekbrains.lesson.store.controllers.utils;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.geekbrains.lesson.store.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ErrorHandlerController {
    @ExceptionHandler (value = ResourceNotFoundException.class)
    public String error(
            ResourceNotFoundException exception,
            Model model
    ){
        System.out.println(exception.getMessage());
        model.addAttribute("error",exception.getMessage());
        return "505";
    }
}
