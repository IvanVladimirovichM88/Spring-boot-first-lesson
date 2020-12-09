package ru.geekbrains.lesson.store.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
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
    public Page<Order> findAll(Specification<Order> specification, int page, int size){
        return orderRepository.findAll(specification, PageRequest.of(page, size));
    }
}