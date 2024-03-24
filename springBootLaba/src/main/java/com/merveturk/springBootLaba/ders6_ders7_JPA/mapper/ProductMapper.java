package com.merveturk.springBootLaba.ders6_ders7_JPA.mapper;


import com.merveturk.springBootLaba.ders6_ders7_JPA.dto.ProductResponseByCategoryDto;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.ProductJpa;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponseByCategoryDto productToProductResponseDtoByCategory(ProductJpa product);

}