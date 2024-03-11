package com.merveturk.springBootLaba.ders5_hibernateYapisi.repository;


import com.merveturk.springBootLaba.ders5_hibernateYapisi.entity.Order;
import com.merveturk.springBootLaba.odev5.entity.Productt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;


    // hibernate ile save işlemi
    @Transactional  // db ye kayit atarken bunu kullanmak zorundasin.
    public void saveOrderOrm(String orderNumber) {
        Order order = new Order();
        order.setOrderNumber(orderNumber);
        entityManager.merge(order);

    }
    // hibernate ile list işlemi
    public List <Order> findByOrderNumberOrm (String orderNumber)
    {
        CriteriaBuilder cr = entityManager.getCriteriaBuilder();
        CriteriaQuery <Order> cq = cr.createQuery(Order.class);

        Root<Order> orderRoot = cq.from (Order.class);
        cq.select(orderRoot).where(cr.equal(orderRoot.get("orderNumber"), orderNumber ));  // producttRoot.get("name") : entity üzerinden gelen  , name  ise dısardan parametre olarak alınan

        return entityManager.createQuery(cq).getResultList();


    }

}