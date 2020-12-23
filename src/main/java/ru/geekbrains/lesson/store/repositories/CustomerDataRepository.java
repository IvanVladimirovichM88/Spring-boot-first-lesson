package ru.geekbrains.lesson.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.geekbrains.lesson.store.data.CustomerData;
import ru.geekbrains.lesson.store.entities.Customer;

import java.util.List;

public interface CustomerDataRepository extends JpaRepository<Customer,Long> {

    @Query("SELECT new ru.geekbrains.lesson.store.data.CustomerData(c) FROM Customer c")
    List<CustomerData> findAllProductData();
}
