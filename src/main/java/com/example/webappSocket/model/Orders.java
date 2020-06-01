package com.example.webappSocket.model;

import javax.persistence.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String time;
    private int numberAdult;
    private int numberChild;
    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean accept;
    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumberAdult() {
        return numberAdult;
    }

    public void setNumberAdult(int numberAdult) {
        this.numberAdult = numberAdult;
    }

    public int getNumberChild() {
        return numberChild;
    }

    public void setNumberChild(int numberChild) {
        this.numberChild = numberChild;
    }

    public boolean getAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}