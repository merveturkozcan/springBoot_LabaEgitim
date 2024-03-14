package com.merveturk.springBootLaba.ders6_SpringJPA.repository;

import com.merveturk.springBootLaba.ders6_SpringJPA.entity.OrderJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.entity.OrderProductJpa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface OrderProductRepositoryJpa extends CrudRepository<OrderProductJpa,Long > {

//        @Query("SELECT op FROM OrderProductJpa op WHERE op.orderJpa.id= :orderId")
//        List<OrderProductJpa> findProductOrdersByOrderId(Long orderId);
//


        List<OrderProductJpa> findAllByOrder (OrderJpa orderJpa );



}




        // parametre olarak aldığı order ile bana tüm product listesini çekti.
        // bu metodu ben kendim yazdım ve CrduRepo içine verilen hangi nesne ise ona ait metodlar yazmamı sağladı.
        // fetch type LAZY halde iken , yüklü datayı tek seferde ön yükleme yapar.
        /*  @Query("select * from OrderProductJpa op where op.id =: orderId")
          List<OrderProductJpa> findByProductByOrderId (Long orderId);
        */




