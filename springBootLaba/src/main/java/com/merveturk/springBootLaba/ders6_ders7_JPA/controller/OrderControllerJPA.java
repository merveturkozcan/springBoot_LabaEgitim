package com.merveturk.springBootLaba.ders6_ders7_JPA.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.merveturk.springBootLaba.ders6_ders7_JPA.dto.OrderSaveRequestDtoJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.service.OrderServiceJPA;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderControllerJPA {

    private final OrderServiceJPA orderServiceJPA;

    public OrderControllerJPA(OrderServiceJPA orderServiceJPA) {

        this.orderServiceJPA = orderServiceJPA;
    }

    @PostMapping("/save")
    public void save(@RequestBody OrderSaveRequestDtoJpa orderSaveRequestDtoJpa) {
        orderServiceJPA.save(orderSaveRequestDtoJpa);

    }

    @PostMapping("/saveOrdersFromJson")
    public void saveOrdersFromJson(@RequestBody String json) throws JsonProcessingException {
        orderServiceJPA.saveOrdersFromJson(json);

    }

    @PostMapping("/saveCascade")
    public void saveCascade(@RequestBody OrderSaveRequestDtoJpa orderSaveRequestDtoJpa){
        orderServiceJPA.saveCascade(orderSaveRequestDtoJpa);

    }

    // manuel olarak iliskisel order silme islemi
    @DeleteMapping("/deleteByOrderId")
    public void delete(@RequestParam Long orderId){

        orderServiceJPA.deleteByOrderId(orderId);
    }

    // cascade olarak iliskisel order silme islemi
    @DeleteMapping("/deleteByOrderIdCascade")
    public void deleteCascade(@RequestParam Long orderId){
        orderServiceJPA.deleteByOrderIdCascade(orderId);
    }





}
