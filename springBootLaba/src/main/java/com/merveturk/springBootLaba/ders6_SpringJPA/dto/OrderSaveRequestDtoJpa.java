package com.merveturk.springBootLaba.ders6_SpringJPA.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class OrderSaveRequestDtoJpa {

    private long productId;
    private String orderDescription;

}
