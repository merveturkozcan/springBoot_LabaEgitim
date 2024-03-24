package com.merveturk.springBootLaba.ders6_ders7_JPA.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponseByCategoryDto {
// kategori listesi cekerken , product entity icinde , o musteriye hangi alanlari acmak istiyorsan o alanlari buraya yazarak kullaniyorsun.
    private String name;
    private String category;
}
