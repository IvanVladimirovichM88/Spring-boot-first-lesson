package ru.geekbrains.lesson.store.controllers.rest;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.lesson.store.entities.Order;
import ru.geekbrains.lesson.store.entities.views.CommonView;
import ru.geekbrains.lesson.store.entities.views.OrderView;
import ru.geekbrains.lesson.store.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders/api/v1")
public class OrderRestController {

    OrderService orderService;

    public OrderRestController(OrderService orderService){
        this.orderService = orderService;
    }


    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(OrderView.Id.class)
    public List<Order> ordersIdToJson(){
        return orderService.findAll();
    }

    @GetMapping(value = "/idCode" )
    @JsonView(OrderView.IdCode.class)
    public List<Order> ordersIdCodeToJson(){
        return orderService.findAll();
    }

    @GetMapping(value = "/idCodeCustomer")
    @JsonView(OrderView.IdCodePriceCustomer.class)
    public List<Order> ordersIdCodeCustomerToJson(){
        return orderService.findAll();
    }

    @GetMapping(value = "/idCodeCustomerOrderEntry")
    @JsonView(OrderView.IdCodeCustomerOrderEntry.class)
    public List<Order> orderIdCOdeCustomerOrderEntryToJson(){
        return orderService.findAll();
    }
}
