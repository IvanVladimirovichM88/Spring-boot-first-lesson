package ru.geekbrains.lesson.store.entities;


import com.fasterxml.jackson.annotation.JsonView;
import ru.geekbrains.lesson.store.entities.views.CommonView;
import ru.geekbrains.lesson.store.entities.views.OrderEntryView;

import javax.persistence.*;

@Entity
@Table(name = "order_item_tbl")
public class OrderEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    @JsonView(CommonView.Id.class)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonView(OrderEntryView.Entry.class)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonView(OrderEntryView.Order.class)
    private Order order;

    @Column(name = "quantity_fld")
    @JsonView(OrderEntryView.Entry.class)
    private int quantity;

    @Column(name = "price_per_product_fld")
    @JsonView(OrderEntryView.Entry.class)
    private Double basePrice;

    @Column(name = "price_fld")
    @JsonView(OrderEntryView.Entry.class)
    private Double totalPrice;
    //////////////////////////////////////////////////////

    public OrderEntry(){
    }

    public OrderEntry(Product product){
        this.product = product;
        this.quantity = 1;
        this.basePrice = product.getPrice();
        this.totalPrice = product.getPrice();
    }
    public OrderEntry(Product product, Order order){
        this.product = product;
        this.quantity = 1;
        this.basePrice = product.getPrice();
        this.totalPrice = product.getPrice();
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
