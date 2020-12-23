package ru.geekbrains.lesson.store.entities.views;

public class CustomerView extends CommonView {
    public interface IdName extends CommonFull{}
    public interface IdNameOrders extends IdName, OrderView.IdCodePriceOrderEntry {}
}
