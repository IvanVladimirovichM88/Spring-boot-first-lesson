package ru.geekbrains.lesson.store.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.geekbrains.lesson.store.entities.Product;

import java.util.Date;

public class ProductData {
    private Long id;
    private String title;
    private String categoryName;
    private Double price;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyDate;
////////////////////////////////////////////////////////
    public ProductData(){}

    public ProductData(Long id, String title, String categoryName, Double price, Date createDate, Date modifyDate) {
        this.id = id;
        this.title = title;
        this.categoryName = categoryName;
        this.price = price;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    public ProductData(Product product){
        this.id = product.getId();
        this.title =product.getTitle();
        this.categoryName = product.getCategory().getTitle();
        this.price = product.getPrice();
        this.createDate = product.getCreateDate();
        this.modifyDate = product.getModifyDate();
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
