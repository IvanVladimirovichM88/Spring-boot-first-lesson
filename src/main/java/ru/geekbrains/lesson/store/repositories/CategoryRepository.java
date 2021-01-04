package ru.geekbrains.lesson.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson.store.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
