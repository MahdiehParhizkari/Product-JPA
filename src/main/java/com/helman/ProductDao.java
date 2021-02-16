package com.helman;

//@project order
//@Author Mahdieh Parhizkari
//@Date 2/7/21
//@Time 12:58PM
//        Created by Intellije IDEA
//        Description:JPA-Criteria

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductDao {
    public ProductDao(){}
    EntityManager entityManager = Myentitymanager.getEntityManager();
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

    public List<Product> findAll(){
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> p = criteriaQuery.from(Product.class);
        criteriaQuery.select(p);
        Query q = entityManager.createQuery(criteriaQuery);
        return q.getResultList();
    }

    public Product findById(int id){
        return entityManager.find(Product.class, id);
    }

    public void insert(Product product){
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    public void update(Product product){
        entityManager.getTransaction().begin();
        product.setName(product.getName());
        product.setCountryid_fk(product.getCountryid_fk());
        product.setCount(product.getCount());
        product.setPrice(product.getPrice());
        product.setCreatedate(product.getCreatedate());
        entityManager.getTransaction().commit();
    }

    public void delete(Product product){
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }
}