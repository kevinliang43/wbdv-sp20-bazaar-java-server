package com.example.wbdvsp20bazaarjavaserver.models;
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

}