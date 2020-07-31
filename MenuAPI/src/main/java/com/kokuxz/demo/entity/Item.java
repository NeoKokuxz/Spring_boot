package com.kokuxz.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*
        Properties
     */
    private String type;
    private String name;
    private Double price;


    /*
        Constructors
     */
    public Item(){}

    public Item(Long id, String type, String itemName, Double price) {
        this.id = id;
        this.type = type;
        this.name = itemName;
        this.price = price;
    }


    /*
        Getters & Setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String itemName) {
        this.name = itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
