package ru.geekbrains.lesson.store.entities.views;

public class OrderEntryView extends CommonView {
    public interface Entry extends CommonFull, ProductView.FullProduct, OrderView.IdCode {}
    public interface Order extends CommonFull, ProductView.FullProduct, OrderView.IdCode {}
}
