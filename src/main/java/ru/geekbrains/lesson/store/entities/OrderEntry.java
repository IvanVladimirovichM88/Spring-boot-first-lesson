package ru.geekbrains.lesson.store.entities;


import ru.geekbrains.lesson.store.utils.OrderFilter;

import javax.persistence.*;
import java.util.Locale;

@Entity
@Table(name = "order_item_tbl")
public class OrderEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "quantity_fld")
    private int quantity;

    @Column(name = "price_per_product_fld")
    private Double basePrice;

    @Column(name = "price_fld")
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
