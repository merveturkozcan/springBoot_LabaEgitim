package com.merveturk.springBootLaba.ders5_hibernateYapisi.repository;


import com.merveturk.springBootLaba.ders5_hibernateYapisi.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional  // db ye kayit atarken bunu kullanmak zorundasin.
    public void saveOrder(String orderNumber) {
        Order order = new Order();
        order.setOrderNumber(orderNumber);
        entityManager.merge(order);
        System.out.printf("");

    }

}