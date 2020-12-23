package ru.geekbrains.lesson.store.entities.views;

public class OrderView extends CommonView {
    public interface IdCode extends CommonFull{}
    public interface IdCodePriceCustomer extends IdCode, CustomerView.IdName{}
    public interface IdCodeCustomerOrderEntry extends IdCodePriceCustomer, OrderEntryView.Entry{}
}
