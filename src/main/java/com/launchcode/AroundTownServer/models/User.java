package com.launchcode.AroundTownServer.models;

import android.support.annotation.Size;
import com.sun.istack.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String pwHash;
//    @ManyToMany(mappedBy = "favorites")
//    private final List<Event> favoriteEvents = new ArrayList<>();

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.pwHash = encoder.encode(password);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public void setPwHash(String pwHash) {
        this.pwHash = pwHash;
    }

    public String getPwHash() {
        return pwHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
