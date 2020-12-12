package ru.geekbrains.lesson.store.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.geekbrains.lesson.store.entities.Customer;
import ru.geekbrains.lesson.store.entities.OrderEntry;
import ru.geekbrains.lesson.store.entities.Product;
import ru.geekbrains.lesson.store.repositories.CustomerRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartService {
    private CustomerRepository customerRepository;

    private List<OrderEntry> orderEntries;
    private Double totalPrice = 0.0;
    private Integer totalQuantity = 0;
    private Customer customer;
    ////////////////////////////////////////////////////

    public CartService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    public void  init(){
        orderEntries = new ArrayList<>();
        customer = customerRepository.getOne(1l);
    }

    public void addOneAndUpdate(Product product){
        for(OrderEntry orderEntry : orderEntries){
            if(orderEntry.getProduct().getId().equals(product.getId())){
                orderEntry.setQuantity((orderEntry).getQuantity() + 1);
                recalculate();
                return;
            }
        }
        orderEntries.add(new OrderEntry(product));
        recalculate();
    }

    public void removeOneAndUpdate(Long productId){
        Iterator<OrderEntry> iterator = getOrderEntryIterator();
        while (iterator.hasNext()){
            OrderEntry orderEntry = iterator.next();
            if(orderEntry.getProduct().getId().equals(productId)){
                if (orderEntry.getQuantity() - 1 == 0) {
                    iterator.remove();
                }
            }else{
                orderEntry.setQuantity(orderEntry.getQuantity() - 1);
            }
            recalculate();
            return;
        }
    }

    public void removeAll(Long productId){
        Iterator<OrderEntry> iterator = getOrderEntryIterator();
        while (iterator.hasNext()){
            OrderEntry orderEntry = iterator.next();
            if(orderEntry.getProduct().getId().equals(productId)) {
                iterator.remove();
            }
            recalculate();
            return;
        }
    }

    private Iterator<OrderEntry> getOrderEntryIterator(){
        return this.orderEntries.iterator();
    }

    public void clearCart(){
        this.orderEntries = new ArrayList<>();
        recalculate();
    }

    public void recalculate(){
        totalPrice = 0.0;
        totalQuantity = 0;
        for (OrderEntry orderEntry :
                this.orderEntries) {
            Double price = orderEntry.getBasePrice() * orderEntry.getQuantity();
            orderEntry.setTotalPrice(price);
            totalPrice += price;
            totalQuantity +=orderEntry.getQuantity();
        }
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<OrderEntry> getOrderEntries() {
        return orderEntries;
    }

    public void setOrderEntries(List<OrderEntry> orderEntries) {
        this.orderEntries = orderEntries;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

