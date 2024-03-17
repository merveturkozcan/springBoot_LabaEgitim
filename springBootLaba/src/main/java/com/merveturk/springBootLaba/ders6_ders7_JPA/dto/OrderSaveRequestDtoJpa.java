package com.merveturk.springBootLaba.ders6_ders7_JPA.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class OrderSaveRequestDtoJpa {

    private long productId;  // order kayıt edilirken productıd de olmali elimizde ancak order a ait bir bilgi yok onu disardan alacagiz
    private String orderDescription;



}
