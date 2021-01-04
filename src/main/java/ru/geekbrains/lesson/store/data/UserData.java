package ru.geekbrains.lesson.store.data;

import ru.geekbrains.lesson.store.entities.Role;
import ru.geekbrains.lesson.store.entities.User;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserData {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String username;
    @NotNull
    private String password;

    private List<String> roles = new ArrayList<>();

    //////////////////////////////////////////////////////////////////

    public UserData() {
    }

    public UserData (User user){
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
