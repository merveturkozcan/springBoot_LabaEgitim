package com.merveturk.springBootLaba.ders6_SpringJPA.controller;


import com.merveturk.springBootLaba.ders6_SpringJPA.dto.OrderSaveRequestDtoJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.service.OrderServiceJPA;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderControllerJPA {

    private final OrderServiceJPA orderServiceJPA;

    public OrderControllerJPA(OrderServiceJPA orderServiceJPA) {

        this.orderServiceJPA = orderServiceJPA;
    }

    @PostMapping("/save")
    public void save(@RequestBody OrderSaveRequestDtoJpa orderSaveRequestDtoJpa){
        orderServiceJPA.save(orderSaveRequestDtoJpa);

    }

}
