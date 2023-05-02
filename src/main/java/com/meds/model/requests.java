package com.meds.model;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "Requests")
public class requests {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    private Users user_id;

    @ManyToOne
    @JoinColumn(name = "medicine_id" , referencedColumnName = "id")
    private medicines medicine_id;

    @Column(name = "request_date")
    private Time request_date;

    @Column(name = "status")
    private long status;

    public requests() {
    }

    public requests(long id, Users user_id, medicines medicine_id, Time request_date, long status) {
        this.id = id;
        this.user_id = user_id;
        this.medicine_id = medicine_id;
        this.request_date = request_date;
        this.status = status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    public void setMedicine_id(medicines medicine_id) {
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

    public Users getUser_id() {
        return user_id;
    }

    public medicines getMedicine_id() {
        return medicine_id;
    }

    public Time getRequest_date() {
        return request_date;
    }

    public long getStatus() {
        return status;
    }
}
