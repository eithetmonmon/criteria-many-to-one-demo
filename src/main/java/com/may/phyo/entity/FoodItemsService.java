package com.may.phyo.entity;

import javax.persistence.EntityManager;

public class FoodItemsService {
    private EntityManager em;
    public FoodItemsService(EntityManager em){
        this.em = em;
    }
    public void createDB(){
        Suppliers suppliers1 = new Suppliers("Kian","Irelan");
        Suppliers suppliers2 = new Suppliers("Shane","Irelan");

        FoodItems meat = new FoodItems("Meat",100);
        FoodItems fish = new FoodItems("Fish",50);
        FoodItems egg = new FoodItems("Egg",100);
        FoodItems veg = new FoodItems("Veg",350);

        suppliers1.getFoodItems().add(meat);
        suppliers1.getFoodItems().add(fish);
        suppliers2.getFoodItems().add(egg);
        suppliers2.getFoodItems().add(veg);



        em.getTransaction().begin();
        em.persist(suppliers1);
        em.persist(suppliers2);
        em.getTransaction().commit();
    }
}
