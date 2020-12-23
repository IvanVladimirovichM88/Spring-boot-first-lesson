package ru.geekbrains.lesson.store.entities;

import com.fasterxml.jackson.annotation.JsonView;
import ru.geekbrains.lesson.store.entities.views.CommonView;
import ru.geekbrains.lesson.store.entities.views.ProductView;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product_tbl")
public class Product extends AbstractItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    @JsonView(CommonView.Id.class)
    private Long id;

    @NotEmpty
    @Size(min = 3,max=20, message = "Title must have 3-20 characters")
    @Column(name = "title_fld")
    @JsonView(ProductView.IdName.class)
    private String title;

    @Column(name = "price_fld")
    @JsonView(ProductView.FullProduct.class)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonView(ProductView.FullProduct.class)
    private Category category;

    ////////////////////////////////////////////////////////////////////////

    public Product(){}

    public Product(String title, Double price){
        this.title = title;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
