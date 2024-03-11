package com.merveturk.springBootLaba.ders6_SpringJPA.entity;

import com.merveturk.springBootLaba.ders5_hibernateYapisi.entity.BaseEntity;
import com.merveturk.springBootLaba.ders5_hibernateYapisi.entity.Order;
import com.merveturk.springBootLaba.ders5_hibernateYapisi.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="order_product_jpa")
@Entity
public class OrderProductJpa extends BaseEntity implements Serializable {

   private static final long serialVersionUID = 1L;

   // fiziksel tablo oluşturmamdaki amaç : başka alanlar da eklenebilsin.
    @ManyToOne
    @JoinColumn(name = " product_id")
    private ProductJpa productJpa;  // product entity den gelen ilişkisel alan.

    @ManyToOne
    @JoinColumn(name = " order_id")
    private OrderJpa orderJpa; // order entity den gelen ilişkisel alan.

}
