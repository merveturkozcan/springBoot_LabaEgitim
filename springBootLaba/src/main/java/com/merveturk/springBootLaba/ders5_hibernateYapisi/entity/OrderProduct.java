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

   // fiziksel tablo oluşturmamdaki amaç : başka alanlar da eklenebilsin.
    @ManyToOne
    @JoinColumn(name = " product_id")
    private Product product;  // product entity den gelen ilişkisel alan.

    @ManyToOne
    @JoinColumn(name = " order_id")
    private Order order; // order entity den gelen ilişkisel alan.

}
