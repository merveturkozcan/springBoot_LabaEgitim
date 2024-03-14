package com.merveturk.springBootLaba.ders6_SpringJPA.entity;

import com.merveturk.springBootLaba.ders5_hibernateYapisi.entity.BaseEntity;
import com.merveturk.springBootLaba.ders5_hibernateYapisi.entity.Order;
import com.merveturk.springBootLaba.ders5_hibernateYapisi.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="OrderProductJpa")
@Entity
public class OrderProductJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   // fiziksel tablo oluşturmamdaki amaç : başka alanlar da eklenebilsin.
    @ManyToOne //(fetch = FetchType.EAGER)
    @JoinColumn(name = " product_id")
    private ProductJpa productJpa;  // product entity den gelen ilişkisel alan.


    // //@ManyToOne(cascade = CascadeType.PERSIST)
    @ManyToOne  //(fetch = FetchType.EAGER)
    @JoinColumn(name = " order_id")
    private OrderJpa orderJpa; // order entity den gelen ilişkisel alan.

}
