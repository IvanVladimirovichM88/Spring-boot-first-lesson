package ru.geekbrains.lesson.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.lesson.store.services.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String firstRequest(Model model){
        model.addAttribute("orders", orderService.findAll());
        return "orders";
    }
}
