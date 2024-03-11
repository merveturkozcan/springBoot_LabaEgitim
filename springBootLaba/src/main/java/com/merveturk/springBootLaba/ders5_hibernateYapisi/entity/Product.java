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

@Table(name="products")  // db adı
@Entity
public class Product extends  BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    private String productName;

    @Column
    private String category;

    @Column
    private String photoUrl;

    @Column
    private String description;

    @Column
    private double price;



    // order ile product ilişkisi yöntem 2 : Fiziksel entity oluşturup ilişki belirtmek. OrderProduct entity incele.
    // orderProduct tablosundaki product alanı ile mapp yapılmış.
    // Not : Order entity içine de aynısı eklendi bak.
    /*  @OneToMany(mappedBy = "product")
    private Set<OrderProduct> orderProducts = new HashSet<>();*/
    // order ile product ilişkisi yöntem 2





    // Order ile Product ilişkisi Yöntem 1 : bu entitiy içine sadece takip amaçlı bu kod yazılır.
    @ManyToMany(mappedBy = "products")
    private Set <Order> orders;
    // Order ile Product ilişkisi Yöntem 1






}
