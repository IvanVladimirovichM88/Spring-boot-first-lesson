//package ru.geekbrains.lesson.store.entities;
//
//import com.fasterxml.jackson.annotation.JsonView;
//import ru.geekbrains.lesson.store.entities.views.CommonView;
//import ru.geekbrains.lesson.store.entities.views.CustomerView;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "customer_tbl")
//public class Customer extends AbstractItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "customer_id")
//    @JsonView(CommonView.Id.class)
//    private Long id;
//
//    @Column(name = "name_fld")
//    @JsonView(CustomerView.IdName.class)
//    private String name;
//
//    @OneToMany(mappedBy = "customer")
//    @JsonView(CustomerView.IdNameOrders.class)
//    private List<Order> orders = new ArrayList<>();
//    ///////////////////////////////////////////////////////
//
//    public Customer(){}
//
//    public Customer(String name){
//        this.name = name;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }
//}
