package com.merveturk.springBootLaba.ders6_SpringJPA.service;


import com.merveturk.springBootLaba.ders6_SpringJPA.entity.OrderJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.entity.OrderProductJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.entity.ProductJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.repository.OrderProductRepositoryJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.repository.OrderRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderProductServiceJpa {

    private final OrderProductRepositoryJpa orderProductRepositoryJpa ;
    private final OrderRepositoryJPA orderRepositoryJPA;
    // private final ProductRepositoryJPA productRepositoryJPA;

    public OrderProductServiceJpa(OrderProductRepositoryJpa orderProductRepositoryJpa, OrderRepositoryJPA orderRepositoryJPA) {
        this.orderProductRepositoryJpa = orderProductRepositoryJpa;
        this.orderRepositoryJPA = orderRepositoryJPA;
    }


    public void getProductByOrderId(Long orderId) {

        OrderJpa orderJpa= orderRepositoryJPA.findById(orderId).get();

        List<OrderProductJpa> allByOrder = orderProductRepositoryJpa.findAllByOrder(orderJpa);
        for (OrderProductJpa orderProduct : allByOrder) {
            ProductJpa product = orderProduct.getProductJpa();
            System.out.printf("product");
        }
    }









}



    // fetch type LAZY halde iken , yüklü datayı tek seferde ön yükleme yapar. Ve sadece bu metod kullanır.


  /*  public void getProductByOrderIdn1Problem(Long orderId) {
        List<OrderProductJpa> allByOrder = orderProductRepositoryJpa.findByProductByOrderId(orderId);
        for (OrderProductJpa orderProductJpa : allByOrder) {
            ProductJpa productJpa = orderProductJpa.getProductJpa();

        }*/

