package com.helman;

//@project order
//@Author Mahdieh Parhizkari
//@Date 2/13/21
//@Time 4:46PM
//        Created by Intellije IDEA
//        Description:JPA-Criteria


import org.junit.Test;

import java.util.Date;
import java.util.List;

public class ProductDaoTest {
    ProductDao productDao = new ProductDao();

    @Test
    public void findAllTest() {
        List<Product> productList = productDao.findAll();
        for(Product pro : productList){
            System.out.println(pro);
        }
    }

    @Test
    public void findByIdTest() {
        Product pro = productDao.findById(36);
        System.out.println(pro);
    }

    @Test
    public void insertTest(){
        Product product = new Product();
        product.setId(30);
        product.setName("Elantra");
        product.setCountryid_fk(1);
        product.setCount(3);
        product.setPrice(Float.parseFloat("2600"));
        product.setCreatedate(new Date());
        productDao.insert(product);
    }

    @Test
    public void updateTest(){
        Product product = productDao.findById(30);
        product.setName("Elantra2019");
        product.setCountryid_fk(3);
        product.setCount(1);
        product.setPrice(Float.parseFloat("3100"));
        product.setCreatedate(new Date());
        productDao.update(product);
    }

    @Test
    public void deleteTest(){
        Product product = productDao.findById(30);
        productDao.delete(product);
    }
}