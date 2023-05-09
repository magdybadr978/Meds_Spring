package com.meds.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Requests")

public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    private User user_id;

    @ManyToOne(cascade={CascadeType.REMOVE})
    @JoinColumn(name = "medicine_id" , referencedColumnName = "id")
    private Medicine medicine_id;

    @Column(name = "request_date")
    private String request_date;

    @Column(name = "status")
    private long status;

    public Request() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.request_date = dateTimeFormatter.format(now);
    }

    public Request(long id, User user_id, Medicine medicine_id, long status) {
        this.id = id;
        this.user_id = user_id;
        this.medicine_id = medicine_id;
        this.status = status;

    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public void setMedicine_id(Medicine medicine_id) {
        this.medicine_id = medicine_id;
    }

    public void setRequest_date(String request_date) {
        this.request_date = request_date;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public long getUser_id() {
        return user_id.getId();
    }// updated

    public long getMedicine_id() {
        return medicine_id.getId();
    }// updated

    public String getRequest_date() {
        return request_date;
    }

    public long getStatus() {
        return status;
    }
}
