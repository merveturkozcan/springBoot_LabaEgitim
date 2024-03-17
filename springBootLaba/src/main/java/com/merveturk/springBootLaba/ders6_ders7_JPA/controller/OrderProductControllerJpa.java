package com.merveturk.springBootLaba.ders6_ders7_JPA.controller;


import com.merveturk.springBootLaba.ders6_ders7_JPA.service.OrderProductServiceJpa;
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

    @GetMapping("/getProductByOrderIdn1Problem")
    public void getProductByOrderIdn1Problem (@RequestParam Long orderId){
        orderProductServiceJpa.getProductByOrderIdn1Problem(orderId);
    }


}
