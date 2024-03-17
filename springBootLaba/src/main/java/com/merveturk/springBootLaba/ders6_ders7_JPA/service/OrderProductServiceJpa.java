package com.merveturk.springBootLaba.ders6_ders7_JPA.service;


import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.OrderJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.OrderProductJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.ProductJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.repository.OrderProductRepositoryJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.repository.OrderRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderProductServiceJpa {

    private final OrderProductRepositoryJpa orderProductRepositoryJpa;
    private final OrderRepositoryJPA orderRepositoryJPA ;


    public OrderProductServiceJpa(OrderProductRepositoryJpa orderProductRepositoryJpa, OrderRepositoryJPA orderRepositoryJPA) {
        this.orderProductRepositoryJpa = orderProductRepositoryJpa;
        this.orderRepositoryJPA = orderRepositoryJPA;
    }


    // bu metod verilen orderId ile birlikte tum product bilgilerini cekmek icin yazilmistir . Bu bilgiler ortak tabloda mevcuttur.
    public void getProductByOrderId(Long orderId) {

        OrderJpa orderJpa = orderRepositoryJPA.findById(orderId).get();
        // elimdeki orderid ile product bilgisini veren sorguyu orderProductRepositoryJpa icine kendim yazdim.
        List<OrderProductJpa> allByOrderJpa = orderProductRepositoryJpa.findAllByOrderJpa(orderJpa);
        for (OrderProductJpa orderProductJpa : allByOrderJpa) {
            ProductJpa productJpa = orderProductJpa.getProductJpa();// datalar geliyor ancak liste halinde return etmedik sadece get yaptik.
        }


    }


    // fetch type LAZY halde iken , VERILEN ORDERID ILE TUM ORDER VE PRODUCT BILGILERINI TEK SEFERDE SISTEME YUKLER .findOrderProductJpasByOrderJpaId KULLANARK
    public void getProductByOrderIdn1Problem(Long orderId) {

        List<OrderProductJpa> allByOrderJpa = orderProductRepositoryJpa.findOrderProductJpasByOrderJpaId(orderId );
        for (OrderProductJpa orderProductJpa : allByOrderJpa) {
            ProductJpa productJpa = orderProductJpa.getProductJpa();// datalar geliyor ancak liste halinde return etmedik sadece get yaptik.
        }
    }
}
