package com.meds.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "name must not be empty")
    private String name;

    @Column(name = "description")
    @NotEmpty(message = "description must not be empty")
    private String description;

    @Column(name = "price")
    @NotNull(message = "price must not be null")
    private long price;


    @Column(name = "expiration_date")
    @NotEmpty(message = "expiration_date must not be empty")
    private String expiration_date;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category_id;

    public Medicine() {
    }

    public Medicine(long id, String name, String description, long price, String expiration_date, Category category_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.expiration_date = expiration_date;
        this.category_id = category_id;
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

    public void setPrice(long price) {
        this.price = price;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
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

    public long getPrice() {
        return price;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public long getCategory_id() {
        return category_id.getId();
    } // updated
}