package com.merveturk.springBootLaba.ders6_SpringJPA.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter @Setter
@NoArgsConstructor


@Table(name="productJpa")  // db adı
@Entity
public class ProductJpa extends  BaseEntity implements Serializable {

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


}
