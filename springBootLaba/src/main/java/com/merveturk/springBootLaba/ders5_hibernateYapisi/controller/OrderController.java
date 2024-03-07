package com.merveturk.springBootLaba.ders5_hibernateYapisi.controller;

import com.merveturk.springBootLaba.ders5_hibernateYapisi.service.OrderService;
import com.merveturk.springBootLaba.odev4_jdbc.dto.ProductDTO;
import com.merveturk.springBootLaba.odev4_jdbc.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public void saveOrder(@RequestParam String orderNumber) {
        orderService.save( orderNumber );

    }

}
