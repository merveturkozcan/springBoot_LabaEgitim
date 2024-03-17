package com.merveturk.springBootLaba.ders6_ders7_JPA.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ProductSaveRequestDtoJpa {

    private String name;
    private String category;
    private String description;
    private String photoUrl;
    private Double price;

    
}
