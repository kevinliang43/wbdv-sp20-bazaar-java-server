package com.example.wbdvsp20bazaarjavaserver.models;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String imageUrl;
    private String email;
    private String firstName;
    private String lastName;
    private String city;
    private String role;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    private List<Listing> listings;

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }

    public String getCity() {
        return this.city;
    }

    public List<Listing> getListings() {
        return this.listings;
    }

    public String getRole() {
        return this.role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public void setListings(List<Listing> listings) {
        this.listings = listings;
    }

    public void setRole(String role) {
        this.role = role;
    }
}