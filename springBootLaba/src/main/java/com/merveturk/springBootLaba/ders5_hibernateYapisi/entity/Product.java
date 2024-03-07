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
    private Date category;

    @Column
    private Double photoUrl;

    @Column
    private String description;

    @Column
    private double price;


    //bu alan database e yansımaz sadece ilişkisi oldugu yeri belirtir.

  //  @ManyToMany(mappedBy = "products")  // order tablosunun products alanı ile ilişkili , mapped olmuş demektir.
   //  private Set < Order > orders;   // order ile many to many ilişkisi varmış.



}
