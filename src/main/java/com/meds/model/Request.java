package com.meds.model;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "Requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    private Admin user_id;

    @ManyToOne
    @JoinColumn(name = "medicine_id" , referencedColumnName = "id")
    private Medicine medicine_id;

    @Column(name = "request_date")
    private Time request_date;

    @Column(name = "status")
    private long status;

    public Request() {
    }

    public Request(long id, Admin user_id, Medicine medicine_id, Time request_date, long status) {
        this.id = id;
        this.user_id = user_id;
        this.medicine_id = medicine_id;
        this.request_date = request_date;
        this.status = status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser_id(Admin user_id) {
        this.user_id = user_id;
    }

    public void setMedicine_id(Medicine medicine_id) {
        this.medicine_id = medicine_id;
    }

    public void setRequest_date(Time request_date) {
        this.request_date = request_date;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public Admin getUser_id() {
        return user_id;
    }

    public Medicine getMedicine_id() {
        return medicine_id;
    }

    public Time getRequest_date() {
        return request_date;
    }

    public long getStatus() {
        return status;
    }
}
