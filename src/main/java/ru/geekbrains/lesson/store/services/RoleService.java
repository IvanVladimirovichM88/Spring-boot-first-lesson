package ru.geekbrains.lesson.store.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.geekbrains.lesson.store.entities.Role;
import ru.geekbrains.lesson.store.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService (RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }
}
