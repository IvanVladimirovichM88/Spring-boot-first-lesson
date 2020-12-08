package ru.geekbrains.lesson.store.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_tbl")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "name_fld")
    private String name;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
    ///////////////////////////////////////////////////////

    public Customer(){}

    public Customer(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
