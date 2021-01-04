package ru.geekbrains.lesson.store.entities.views;

public class OrderView extends CommonView {
    public interface IdCode extends CommonFull{}
    public interface Price {}
    public interface OrderEntry extends OrderEntryView.Entry{}
    public interface IdCodePriceOrderEntry extends IdCode, Price, OrderEntry{}
    public interface IdCodePriceCustomer extends IdCode, CustomerView.IdName{}
    public interface IdCodeCustomerOrderEntry extends IdCodePriceCustomer, OrderEntry{}
}
