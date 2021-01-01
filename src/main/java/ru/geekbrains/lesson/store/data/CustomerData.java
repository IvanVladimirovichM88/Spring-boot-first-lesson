//package ru.geekbrains.lesson.store.data;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import ru.geekbrains.lesson.store.entities.Customer;
//
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class CustomerData {
//
//    private Long id;
//    private String name;
//    private List<String> ordersCode;
//    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date createDate;
//    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date modifyDate;
//    ///////////////////////////////////////////////////////////////////////////////
//
//
//    public CustomerData() {
//    }
//
//    public CustomerData(Long id, String name, List <String> orderCode, Date createDate, Date modifyDate) {
//        this.id = id;
//        this.name = name;
//        this.ordersCode = orderCode;
//        this.createDate = createDate;
//        this.modifyDate = modifyDate;
//    }
//
//    public CustomerData(Customer customer){
//        this.id = customer.getId();
//        this.name = customer.getName();
//        this.ordersCode = customer.getOrders().stream().map(order->order.getCode()).collect(Collectors.toList());
//        this.createDate = customer.getCreateDate();
//        this.modifyDate = customer.getModifyDate();
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
//    public List<String> getOrdersCode() {
//        return ordersCode;
//    }
//
//    public void setOrdersCode(List<String> ordersCode) {
//        this.ordersCode = ordersCode;
//    }
//
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//    public Date getModifyDate() {
//        return modifyDate;
//    }
//
//    public void setModifyDate(Date modifyDate) {
//        this.modifyDate = modifyDate;
//    }
//}
