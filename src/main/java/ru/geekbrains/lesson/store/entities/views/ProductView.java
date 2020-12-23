package ru.geekbrains.lesson.store.entities.views;

public class ProductView extends CommonView{
    public interface IdName extends CommonFull{}
    public interface FullProduct extends CommonFull, IdName{}
}
