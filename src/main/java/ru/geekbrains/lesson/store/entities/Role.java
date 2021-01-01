package ru.geekbrains.lesson.store.entities;


import javax.persistence.*;

@Entity
@Table(name = "role_tbl")
public class Role extends AbstractItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "name_fld")
    private String name;
///////////////////////////////////////////////////////////////////
    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
