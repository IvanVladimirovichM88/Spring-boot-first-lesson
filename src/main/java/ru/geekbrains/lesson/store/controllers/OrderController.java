package ru.geekbrains.lesson.store.controllers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.lesson.store.entities.Order;
import ru.geekbrains.lesson.store.services.OrderService;
import ru.geekbrains.lesson.store.utils.OrderFilter;

import java.util.Map;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String firstRequest(
            Model model,
            @RequestParam (defaultValue = "1",name = "p") Integer page,
            @RequestParam Map<String,String> params
            ){

        if (page<1){
            page=1;
        }
        OrderFilter orderFilter = new OrderFilter(params);
        Page<Order> orders = orderService.findAll(orderFilter.getSpecification(), page-1, 3);
        model.addAttribute("orders",orders);
        model.addAttribute("filterDefinition", orderFilter.getFilterDefinition());
        return "orders";
    }


}
