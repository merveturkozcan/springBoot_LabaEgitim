package com.merveturk.springBootLaba.ders6_SpringJPA.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter @Setter
@NoArgsConstructor


@Table(name="orderJpa")  // db adı
@Entity
public class OrderJpa extends  BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    private String orderNumber;
    private String description;
    private Date orderDate;
    private Double totalAmount;


}
