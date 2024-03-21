package com.merveturk.springBootLaba.ders6_ders7_JPA.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class OrderSaveRequestDtoJpa {


     // private long productId;
     List<Long> productIdList;
     private String orderDescription;


     // order kayıt edilirken productıd de olmali elimizde ancak order a ait bir bilgi yok onu disardan alacagiz








}
