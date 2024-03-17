package com.merveturk.springBootLaba.ders6_SpringJPA.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;


@Getter @Setter
@NoArgsConstructor


@Table(name="ProductJpa")  // db adı
@Entity
public class ProductJpa extends  BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    private String name;
    private String category;
    private String photoUrl;
    private String description;
    private double price;


    @OneToMany(mappedBy = "productJpa")
    private Set<OrderProductJpa> orderProducts = new HashSet<>();


}
