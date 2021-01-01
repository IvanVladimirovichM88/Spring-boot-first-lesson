package ru.geekbrains.lesson.store.data;

import ru.geekbrains.lesson.store.entities.User;

import javax.validation.constraints.NotNull;

public class UserData {
    @NotNull
    private String name;
    @NotNull
    private String username;
    @NotNull
    private String password;

    //////////////////////////////////////////////////////////////////

    public UserData() {
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
}
