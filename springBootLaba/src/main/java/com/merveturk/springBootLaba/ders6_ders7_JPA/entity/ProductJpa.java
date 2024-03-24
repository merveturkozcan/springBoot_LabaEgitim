package com.merveturk.springBootLaba.ders6_ders7_JPA.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;


@Data
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
