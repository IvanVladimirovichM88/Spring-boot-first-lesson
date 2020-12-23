package ru.geekbrains.lesson.store.entities;

import com.fasterxml.jackson.annotation.JsonView;
import ru.geekbrains.lesson.store.entities.views.CommonView;
import ru.geekbrains.lesson.store.entities.views.OrderView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_tbl")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @JsonView(CommonView.Id.class)
    private Long id;

    @Column(name = "code_fld")
    @JsonView(OrderView.IdCode.class)
    private String code;

    @Column(name = "total_price_fld")
    @JsonView(OrderView.Price.class)
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonView(OrderView.IdCodePriceCustomer.class)
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonView(OrderView.OrderEntry.class)
    private List<OrderEntry> orderEntries = new ArrayList<>();
    ////////////////////////////////////////////////////////////


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderEntry> getOrderEntries() {
        return orderEntries;
    }

    public void setOrderEntries(List<OrderEntry> orderEntries) {
        this.orderEntries = orderEntries;
    }
}
