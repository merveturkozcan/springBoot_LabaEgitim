package com.merveturk.springBootLaba.ders6_ders7_JPA.utils;


import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.OrderJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.OrderProductJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.ProductJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.repository.OrderProductRepositoryJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.repository.OrderRepositoryJPA;
import com.merveturk.springBootLaba.ders6_ders7_JPA.repository.ProductRepositoryJPA;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class UtilOrderProductSave {

    private final OrderRepositoryJPA orderRepositoryJPA;
    private final ProductRepositoryJPA productRepositoryJPA;
    private final OrderProductRepositoryJpa orderProductRepositoryJpa;


    public UtilOrderProductSave(OrderRepositoryJPA orderRepositoryJPA, ProductRepositoryJPA productRepositoryJPA, OrderProductRepositoryJpa orderProductRepositoryJpa) {
        this.orderRepositoryJPA = orderRepositoryJPA;
        this.productRepositoryJPA = productRepositoryJPA;
        this.orderProductRepositoryJpa = orderProductRepositoryJpa;
    }


    @PostConstruct
    public void test() {

        ProductJpa product = new ProductJpa();

        product.setName("ıphone 15");
        product.setCategory("phone");
        product.setPhotoUrl("www.merve.com");
        product.setDescription("Aciklama urun 1");
        product.setPrice(30.0);
        productRepositoryJPA.save(product);

        ProductJpa product2 = new ProductJpa();
        product2.setName("SamsungAx");
        product2.setCategory("tv");
        product2.setPhotoUrl("www.merve.com");
        product2.setDescription("Aciklama urun 2");
        product2.setPrice(20.0);
        productRepositoryJPA.save(product2);

        ProductJpa product3 = new ProductJpa();
        product3.setCategory("phone");
        product3.setName("ıphone 12");
        product3.setPhotoUrl("www.merve.com");
        product3.setDescription("Aciklama urun 3");
        product3.setPrice(30.0);
        productRepositoryJPA.save(product3);

        OrderJpa order = new OrderJpa();
        order.setOrderDescription("order desc1");

        OrderProductJpa orderProduct = new OrderProductJpa();
        orderProduct.setOrderJpa(order);
        orderProduct.setProductJpa(product);
        orderProductRepositoryJpa.save(orderProduct);

       /* Users users = new Users();
        users.setName("Merve");
        users.setLastName("Turk");
        userRepository.save(users);*/


    }












}
