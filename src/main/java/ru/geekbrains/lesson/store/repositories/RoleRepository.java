package ru.geekbrains.lesson.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.lesson.store.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);
}
