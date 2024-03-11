package com.merveturk.springBootLaba.ders5_hibernateYapisi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="orders")
@Entity
public class Order extends BaseEntity implements Serializable {

   private static final long serialVersionUID = 1L;

    @Column
    private String orderNumber;
    private Date orderDate;
    private Double totalAmount;


    // Order ile Product ilişkisi Yöntem 1 - sanal  //
    // orderProduct ara tablosunu sanal şekilde oluşturuyoruz. Sadece hibernate oluşturup ilişki kurar fiziksel tablo oluşmaz.
    // orderProduct tablosunda sadece 2 kolon açabiliriz birisi orderid diğeri ise productid
    // not : Product entity'de bu ilişkiyi belirten sadece takip amaçlı kod satırı eklendi.
    @ManyToMany
    @JoinTable(
            name= "Order_Product",
            joinColumns = { @JoinColumn(name= "order_id") }, // order class içindeyiz buradaki order_id ile
            inverseJoinColumns = { @JoinColumn(name = "product_id")} // product tablosundaki (aşağıdaki satır) product_id kolonu eşleşiyor.
    )
    private Set<Product> products;
    // Order ile Product ilişkisi Yöntem 1  //



 // order ile product ilişkisi yöntem 2 - Fiziksel entity oluşturup ilişki belirtmek. OrderProduct entity incele.
 // orderProduct tablosundaki order alanı ile mapp yapılmış.
 // Not : Product entity içine de aynısı eklendi bak.

 /*@OneToMany(mappedBy = "order")
 private Set<OrderProduct> orderProducts = new HashSet<>();*/

 // order ile product ilişkisi yöntem 2




}
