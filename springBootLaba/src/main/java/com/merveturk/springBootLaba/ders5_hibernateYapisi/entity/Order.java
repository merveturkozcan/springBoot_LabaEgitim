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

}
