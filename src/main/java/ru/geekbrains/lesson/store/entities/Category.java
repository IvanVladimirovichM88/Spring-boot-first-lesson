package ru.geekbrains.lesson.store.entities;

import com.fasterxml.jackson.annotation.JsonView;
import ru.geekbrains.lesson.store.entities.views.CommonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category_tbl")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    @JsonView(CommonView.Id.class)
    private Long id;

    @Column(name = "title_fld")
    private String title;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<Product> products;
    /////////////////////////////////////////////////

    public Category(){
        this.products = new ArrayList<>();
    }

    public Category(String title){
        this.title = title;
        this.products = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
