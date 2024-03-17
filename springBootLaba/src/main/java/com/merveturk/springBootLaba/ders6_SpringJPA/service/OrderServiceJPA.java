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


    // bu metod  order-product birlikte kayit etmek icin islem yapar. cunku her order icinde bir product var.
    public void save(OrderSaveRequestDtoJpa orderSaveRequestDtoJpa) {

        long productId = orderSaveRequestDtoJpa.getProductId();
        String orderDescription = orderSaveRequestDtoJpa.getOrderDescription();
        // bu iki alan da dto dan geliyor .

        OrderJpa order = new OrderJpa();
        order.setOrderDescription(orderDescription);  // disardan aldigim description burada order icine verildi
        orderRepositoryJPA.save(order); // bu alanlari set edip oncelikle order kaydi yapilir sonra orderProduct kaydi yapilir,


        // burda da disardan gelen productId ile ilgili product kaydini buluyoruz once.
        ProductJpa product = productServiceJPA.findProductById(productId); // bu metoda biz yazdik dogru katmanda calismak icin .

        // burada da hem order hem product kaydını orderProduct iliskisini buraya set ederek
        OrderProductJpa orderProduct = new OrderProductJpa();
        orderProduct.setProductJpa(product);
        orderProduct.setOrderJpa(order);

        // kaydet yapıyoruz.
        orderProductRepositoryJpa.save(orderProduct); // burda da orderService orderRepoya erisimi olmamasi lazim ,

    }


}
