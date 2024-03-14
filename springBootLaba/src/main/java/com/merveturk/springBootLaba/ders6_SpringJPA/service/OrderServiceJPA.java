package com.merveturk.springBootLaba.ders6_SpringJPA.service;


import com.merveturk.springBootLaba.ders6_SpringJPA.dto.OrderSaveRequestDtoJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.entity.OrderJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.entity.OrderProductJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.entity.ProductJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.repository.OrderProductRepositoryJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.repository.OrderRepositoryJPA;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceJPA {


    private final OrderRepositoryJPA orderRepositoryJPA;
    private final ProductServiceJPA productServiceJPA;
    private final OrderProductRepositoryJpa orderProductRepositoryJpa;

    public OrderServiceJPA(OrderRepositoryJPA orderRepositoryJPA, ProductServiceJPA productServiceJPA, OrderProductRepositoryJpa orderProductRepositoryJpa) {
        this.orderRepositoryJPA = orderRepositoryJPA;
        this.productServiceJPA = productServiceJPA;
        this.orderProductRepositoryJpa = orderProductRepositoryJpa;
    }


    public void save(OrderSaveRequestDtoJpa orderSaveRequestDtoJpa) {

        long productId = orderSaveRequestDtoJpa.getProductId();
        String orderDescription = orderSaveRequestDtoJpa.getOrderDescription();

        OrderJpa order = new OrderJpa();
        order.setOrderDescription(orderDescription);
        orderRepositoryJPA.save(order);

        ProductJpa product = productServiceJPA.findProductById(productId);

        OrderProductJpa orderProduct = new OrderProductJpa();
        orderProduct.setProductJpa(product);
        orderProduct.setOrderJpa(order);

        orderProductRepositoryJpa.save(orderProduct);

    }


}
