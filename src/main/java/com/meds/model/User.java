package com.meds.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    @NotEmpty(message = "name must not be empty")
    private String name;


    @Column(name = "email")
    @Email(message = "you should enter a valid email")
    private String email;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Request> requests = new ArrayList<>();

    @Column(name = "password")
    @NotEmpty(message = "password must not be empty")
    private String password;


    @Column(name = "phone", unique = true)
    @NotEmpty(message = "phone must not be empty")
    private String phone;


    @Column(name = "status")
    private long status;


    @Column(name = "type")
    private long type;


    public User() {

    }

    public User(long id, String name, String email, String password, String phone, long status, long type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.type = type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public void setType(long type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public long getStatus() {
        return status;
    }

    public long getType() {
        return type;
    }


}
