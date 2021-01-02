package com.may.phyo.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("criteria");
        EntityManager em = emf.createEntityManager();

        FoodItemsService foodItemsService = new FoodItemsService(em);
        foodItemsService.createDB();
        //Inner Join - select s.name,f.name from Supplier s join s.fooditems f

       CriteriaBuilder cb = em.getCriteriaBuilder();
       CriteriaQuery<Tuple> query = cb.createTupleQuery();
       Root<Suppliers> suppliers = query.from(Suppliers.class);
       Join<Suppliers,FoodItems> foodItems = suppliers.join("foodItems");
       query.multiselect(suppliers.get("name"),foodItems.get("name"));


       TypedQuery<Tuple> typedQuery = em.createQuery(query);
       List<Tuple> list = typedQuery.getResultList();

        for (Tuple tuple : list){
            System.out.println("Supplier : "+tuple.get(0) +" =>" + "FoodItem : "+tuple.get(1));
        }


        em.close();
        emf.close();

        com.may.phyo.util.JPAUtil.checkData("select * from suppliers");
        com.may.phyo.util.JPAUtil.checkData("select * from fooditems");
    }
}
