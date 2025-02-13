package com.gaming.store.gaming_store_users.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "adress")
    private String  adress;

    @Column(name = "country_code")
    private String country_code;

    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "last_login")
    private LocalDateTime last_login;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public LocalDateTime getLast_login() {
        return last_login;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public void setLast_login(LocalDateTime last_login) {
        this.last_login = last_login;
    }
}
