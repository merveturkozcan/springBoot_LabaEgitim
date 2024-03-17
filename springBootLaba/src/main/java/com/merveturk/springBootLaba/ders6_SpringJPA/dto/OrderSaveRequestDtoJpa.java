package com.merveturk.springBootLaba.ders6_SpringJPA.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class OrderSaveRequestDtoJpa {

    private long productId;  // order kayıt edilirken productıd de olmali elimizde ancak order a ait bir bilgi yok onu disardan alacagiz
    private String orderDescription;



}
