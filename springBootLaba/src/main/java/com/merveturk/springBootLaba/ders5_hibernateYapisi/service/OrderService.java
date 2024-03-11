package com.merveturk.springBootLaba.ders5_hibernateYapisi.service;

import com.merveturk.springBootLaba.ders5_hibernateYapisi.entity.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.merveturk.springBootLaba.ders5_hibernateYapisi.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }




    public void saveOrderOrm( String orderNumber) {
        orderRepository.saveOrderOrm(orderNumber);
    }

    public List<Order> findByOrderNumberOrm(String orderNumber) {
       return  orderRepository.findByOrderNumberOrm(orderNumber);

    }





}
