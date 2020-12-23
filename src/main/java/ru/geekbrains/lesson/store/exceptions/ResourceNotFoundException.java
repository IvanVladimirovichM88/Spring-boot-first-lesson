package ru.geekbrains.lesson.store.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id ){
        super("product with id: " + id +" doesn't exists");
    }
    public ResourceNotFoundException(Long id, String details ){
        super("product with id: " + id + " doesn't exists " + "(" + details + ")");
    }
}
