package com.helman;

//@project order
//@Author Mahdieh Parhizkari
//@Date 2/7/21
//@Time 1:23PM
//        Created by Intellije IDEA
//        Description:JPA-Criteria

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

public class Myentitymanager {
    private static EntityManagerFactory entityManagerFactory = null;

    public static EntityManager getEntityManager(){
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("prodbconfig");
            return entityManagerFactory.createEntityManager();
    } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public static CriteriaBuilder getCriteriaBuilder(){
        return getEntityManager().getCriteriaBuilder();
    }

}