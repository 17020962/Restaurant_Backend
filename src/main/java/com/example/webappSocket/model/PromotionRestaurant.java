package com.example.webappSocket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PromotionRestaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int name;
    @Column(columnDefinition = "Text")
    private String description;
    @Column(columnDefinition = "Text")
    private String image;

}
