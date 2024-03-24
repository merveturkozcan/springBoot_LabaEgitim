package com.merveturk.springBootLaba.ders6_ders7_JPA.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor


@Table(name="OrderJpa")  // db adı
@Entity
public class OrderJpa extends  BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    private String orderNumber;
    private Date orderDate;
    private String orderDescription;
    private Double totalAmount;

    @OneToMany(mappedBy = "orderJpa" , cascade = CascadeType.ALL)
    private Set<OrderProductJpa> orderProductJpa = new HashSet<>();




}
