package com.merveturk.springBootLaba.ders6_ders7_JPA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = " product_id")
    private ProductJpa productJpa;



    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST) // cascade = CascadeType.PERSIST bunu yazinca order save olurken orderRepo.save() kullanmaya gerek kalmaz.
    @JoinColumn(name = " order_id")
    private OrderJpa orderJpa;



}
