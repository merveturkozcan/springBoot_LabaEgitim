package com.merveturk.springBootLaba.ders6_SpringJPA.entity;

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
public class OrderProductJpa  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String kargoName;


    @ManyToOne (fetch = FetchType.LAZY)//(fetch = FetchType.EAGER , cascade= CascadeType.PERSIST)
    @JoinColumn(name = " product_id")
    private ProductJpa productJpa;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = " order_id")
    private OrderJpa orderJpa;



}
