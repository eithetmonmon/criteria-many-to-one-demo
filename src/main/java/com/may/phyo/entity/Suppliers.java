package com.may.phyo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    @OneToMany(cascade = CascadeType.PERSIST)
    List<FoodItems> foodItems = new ArrayList<>();

    public Suppliers() {
    }

    public Suppliers(String name, String address) {
        this.name = name;
        this.address = address;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<FoodItems> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItems> foodItems) {
        this.foodItems = foodItems;
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", foodItems=" + foodItems +
                '}';
    }
}
