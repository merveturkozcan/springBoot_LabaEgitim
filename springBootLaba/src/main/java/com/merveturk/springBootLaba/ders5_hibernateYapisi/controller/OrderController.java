package com.merveturk.springBootLaba.ders5_hibernateYapisi.controller;

import com.merveturk.springBootLaba.ders5_hibernateYapisi.entity.Order;
import com.merveturk.springBootLaba.ders5_hibernateYapisi.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/saveOrderOrm")
    public void saveOrderOrm(@RequestParam String orderNumber) {
        orderService.saveOrderOrm( orderNumber );

    }

    @GetMapping("/findByOrderNumberOrm")
    public List<Order> findByOrderNumberOrm (@RequestParam String orderNumber)
    {
       return  orderService.findByOrderNumberOrm(orderNumber);

    }

}
