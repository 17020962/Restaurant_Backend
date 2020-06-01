package com.example.webappSocket.model;

import javax.persistence.*;

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @Column(columnDefinition = "TEXT")
    private String image;
    private int cost;
//    private int costPromotion;
    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "typeid")
    private TypeDish typeDish;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeDish getTypeDish() {
        return typeDish;
    }

    public void setTypeDish(TypeDish typeDish) {
        this.typeDish = typeDish;
    }

}
