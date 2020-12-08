package ru.geekbrains.lesson.store.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.lesson.store.entities.Order;
import ru.geekbrains.lesson.store.repositories.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }
}