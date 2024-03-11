package com.merveturk.springBootLaba.ders6_SpringJPA.service;


import com.merveturk.springBootLaba.ders6_SpringJPA.dto.OrderSaveRequestDtoJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.entity.OrderJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.entity.OrderProductJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.entity.ProductJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.repository.OrderProductRepositoryJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.repository.OrderRepositoryJPA;
import com.merveturk.springBootLaba.ders6_SpringJPA.repository.ProductRepositoryJPA;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceJPA {

    private final OrderRepositoryJPA orderRepositoryJPA;
    private final ProductRepositoryJPA productRepositoryJPA;
    private final OrderProductRepositoryJpa orderProductRepositoryJpa;

    public OrderServiceJPA(OrderRepositoryJPA orderRepositoryJPA, ProductRepositoryJPA productRepositoryJPA, OrderProductRepositoryJpa orderProductRepositoryJpa) {
        this.orderRepositoryJPA = orderRepositoryJPA;
        this.productRepositoryJPA = productRepositoryJPA;
        this.orderProductRepositoryJpa = orderProductRepositoryJpa;
    }


    public void save(OrderSaveRequestDtoJpa orderSaveRequestDtoJpa) {

        long productId = orderSaveRequestDtoJpa.getProductId();
        String orderDescription = orderSaveRequestDtoJpa.getOrderDescription();
        OrderJpa order = new OrderJpa();
        order.setDescription(orderDescription);
        orderRepositoryJPA.save(order);

        ProductJpa product = productRepositoryJPA.findById(productId).get();

        OrderProductJpa orderProductJpa = new OrderProductJpa();
        orderProductJpa.setProductJpa(product);
        orderProductJpa.setOrderJpa(order);

        orderProductRepositoryJpa.save(orderProductJpa);









    }


}
