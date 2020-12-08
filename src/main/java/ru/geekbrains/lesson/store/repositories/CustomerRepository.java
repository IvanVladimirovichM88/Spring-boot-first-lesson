package ru.geekbrains.lesson.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson.store.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
