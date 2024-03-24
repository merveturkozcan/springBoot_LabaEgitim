package com.merveturk.springBootLaba.ders6_ders7_JPA.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.merveturk.springBootLaba.ders6_ders7_JPA.dto.OrderSaveRequestDtoJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.OrderJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.OrderProductJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.ProductJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.repository.OrderProductRepositoryJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.repository.OrderRepositoryJPA;
import com.merveturk.springBootLaba.ders6_ders7_JPA.repository.ProductRepositoryJPA;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    @SneakyThrows
    public void saveOrdersFromJson(String json) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        OrderSaveRequestDtoJpa[] orders = objectMapper.readValue(json, OrderSaveRequestDtoJpa[].class);
        for (OrderSaveRequestDtoJpa order : orders) {

            String desc = order.getOrderDescription();
            List<Long> productIdListid = order.getProductIdList();


            OrderJpa create = new OrderJpa();
            create.setOrderDescription(desc);
            orderRepositoryJPA.save(create);

            for (Long l : productIdListid) {
                ProductJpa product = productServiceJPA.findProductById(l);
                OrderProductJpa orderProduct = new OrderProductJpa();
                orderProduct.setProductJpa(product);
                orderProduct.setOrderJpa(create);
                orderProductRepositoryJpa.save(orderProduct);
            }
        }
    }


    // bu metod  order-product birlikte kayit etmek icin islem yapar. cunku her order icinde bir product var.
    // disardan aldigim description burada order icine verildi
    // bu alanlari set edip oncelikle order kaydi yapilir sonra orderProduct kaydi yapilir,
    // burda da disardan gelen productId ile ilgili product kaydini buluyoruz once.
    // burada da hem order hem product kaydını orderProduct iliskisini buraya set ederek
    // kaydet yapıyoruz.
    // burda da orderService orderRepoya erisimi olmamasi lazim ,
    // long productId = orderSaveRequestDtoJpa.getProductId();




    public void save(OrderSaveRequestDtoJpa orderSaveRequestDtoJpa) {

        List <Long> productIdList = orderSaveRequestDtoJpa.getProductIdList();
        String orderDescription = orderSaveRequestDtoJpa.getOrderDescription();

        OrderJpa order = new OrderJpa();
        order.setOrderDescription(orderDescription);
        orderRepositoryJPA.save(order);

        for (Long l : productIdList) {

            ProductJpa productById = productServiceJPA.findProductById(l);
            OrderProductJpa orderProductJpa = new OrderProductJpa();
            orderProductJpa.setProductJpa(productById);
            orderProductJpa.setOrderJpa(order);
            orderProductRepositoryJpa.save(orderProductJpa);
           }

        }


    public void saveCascade(OrderSaveRequestDtoJpa orderSaveRequestDtoJpa) {

        List<Long> productIdList = orderSaveRequestDtoJpa.getProductIdList();
        String orderDescription = orderSaveRequestDtoJpa.getOrderDescription();

        OrderJpa order = new OrderJpa();
        order.setOrderDescription(orderDescription);

        //  non-functional  //
        /*  for (Long productId : productIdList) {
            ProductJpa product = productServiceJPA.findProductById(productId);
            OrderProductJpa orderProduct = new OrderProductJpa();
            orderProduct.setProductJpa(product);
            orderProduct.setOrderJpa(order);
            orderProductRepositoryJpa.save(orderProduct);
        }*/

        //  functional version 1 //
        /*List<ProductJpa> productList = productIdList.stream().map(productServiceJPA::findProductById).toList();
        productList.stream().forEach(product-> {
            OrderProductJpa orderProduct = new OrderProductJpa();
            orderProduct.setProductJpa(product);
            orderProduct.setOrderJpa(order);*/

        // functional version 2 //
        productIdList
                .stream()
                .map(productServiceJPA::findProductById)
                .forEach(product -> {   //map sonucu gelen degeri foreach ile donecektir.
                    OrderProductJpa orderProduct = new OrderProductJpa();
                    orderProduct.setProductJpa(product);
                    orderProduct.setOrderJpa(order);
        });
    }


    // order silinmesi icin once order uzerindeki tum product yok olmasi lazim
    public void deleteByOrderId(Long orderId) {

        OrderJpa orderJpa = orderRepositoryJPA.findById(orderId).get();

        //once product kac tane ise hepsini sil
        List<OrderProductJpa> allByOrderJpa = orderProductRepositoryJpa.findAllByOrderJpa(orderJpa);
        for (OrderProductJpa orderProductJpa : allByOrderJpa) {
            orderProductRepositoryJpa.delete(orderProductJpa);
        }

        //sonra order datasini ucur.
        orderRepositoryJPA.delete(orderJpa);
    }

    public void deleteByOrderIdCascade(Long orderId) {
        OrderJpa orderJpa = orderRepositoryJPA.findById(orderId).get();
        orderRepositoryJPA.delete(orderJpa);
    }
}
