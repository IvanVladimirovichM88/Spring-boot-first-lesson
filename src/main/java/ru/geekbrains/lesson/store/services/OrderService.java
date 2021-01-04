package ru.geekbrains.lesson.store.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.lesson.store.entities.Order;
import ru.geekbrains.lesson.store.entities.User;
import ru.geekbrains.lesson.store.repositories.OrderRepository;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private CartService cartService;
    private UserService  userService;


    public OrderService(OrderRepository orderRepository, CartService cartService,UserService userService){
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.userService = userService;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }
    public Page<Order> findAll(Specification<Order> specification, int page, int size){
        return orderRepository.findAll(specification, PageRequest.of(page, size));
    }

    @Transactional
    public Order createOrder(Principal principal){
        Order order = new Order();
        order.setCode(UUID.randomUUID().toString().substring(0,4));
        User user = userService.getCurrentUser(principal);
        System.out.println("\n--->> createOrder user  = " + user);
        order.setUser(user);
        order.setTotalPrice(cartService.getTotalPrice());
        order.setOrderEntries(cartService.getOrderEntries());
        cartService.getOrderEntries().stream().forEach(orderEntry -> {
            orderEntry.setOrder(order);
        });
        orderRepository.save(order);
        cartService.clearCart();
        return order;
    }

    public void remove(Long id){
        orderRepository.deleteById(id);
    }
}