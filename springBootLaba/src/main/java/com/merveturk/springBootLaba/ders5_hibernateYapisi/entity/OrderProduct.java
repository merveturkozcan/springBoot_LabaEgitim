package com.merveturk.springBootLaba.ders5_hibernateYapisi.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="order_product")
@Entity
public class OrderProduct extends BaseEntity implements Serializable {

   private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = " product_id")
    private Product product;   // x numaralı kaç tane orderproduct satırında bulunur

    @ManyToOne
    @JoinColumn(name = " order_id")
    private Order order;

}
