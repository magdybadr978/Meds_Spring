package com.hr.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "Categories")
public class categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "name")
    @NotEmpty(message = "name must not be empty")
    private String name;
    @Column(name = "description")
    @NotEmpty(message = "description must not be empty")
    private  String description;

    public categories() {

    }

    public categories(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
