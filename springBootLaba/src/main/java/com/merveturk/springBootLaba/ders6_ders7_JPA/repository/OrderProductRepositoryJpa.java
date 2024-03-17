package com.merveturk.springBootLaba.ders6_ders7_JPA.repository;

import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.OrderJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.OrderProductJpa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



import java.util.List;

public interface OrderProductRepositoryJpa extends CrudRepository<OrderProductJpa,Long > {

        //n1 problemi icin yazilan query ; amaci fetchType.LAZY yapisinda tek seferde product yuklesin diye.
        @Query("SELECT X FROM OrderProductJpa X where X.orderJpa.id =  :orderId")
        List<OrderProductJpa> findOrderProductJpasByOrderJpaId(Long orderId);


        // elimdeki orderid ile product bilgisini veren sorguyu kendim yazdim.
        List<OrderProductJpa> findAllByOrderJpa(OrderJpa orderJpa);








}

