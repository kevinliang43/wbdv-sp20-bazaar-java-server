package com.example.wbdvsp20bazaarjavaserver.models;

import java.util.Date;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "listings")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String type;
    private String description;
    private float price;
    private String city;
    private String imageUrl;

    @ManyToOne
    @JsonIgnore
    private User user;

    private int uid;

    @Temporal(TemporalType.DATE)
    private Date date;

    // Getters
    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }

    public float getPrice() {
        return this.price;
    }

    public String getCity() {
        return this.city;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public User getUser() {
        return this.user;
    }

    public int getUid() {
        return this.uid;
    }

    public Date getDate() {
        return this.date;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}