package com.merveturk.springBootLaba.ders6_SpringJPA.controller;


import com.merveturk.springBootLaba.ders6_SpringJPA.dto.ProductSaveRequestDtoJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.service.OrderProductServiceJpa;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderProduct")
public class OrderProductControllerJpa {

    private final OrderProductServiceJpa orderProductServiceJpa;

    public OrderProductControllerJpa(OrderProductServiceJpa orderProductServiceJpa) {
        this.orderProductServiceJpa = orderProductServiceJpa;
    }


    //verilen orderId ile içerisindeki product bilgisini çeken api


    @GetMapping("/getProductByOrderId")
         public void getProductByOrderId (@RequestParam Long orderId){
              orderProductServiceJpa.getProductByOrderId(orderId);
    }


}
