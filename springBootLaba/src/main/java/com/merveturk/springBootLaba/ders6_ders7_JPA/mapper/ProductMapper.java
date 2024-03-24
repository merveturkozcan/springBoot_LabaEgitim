package com.merveturk.springBootLaba.ders6_ders7_JPA.mapper;


import com.merveturk.springBootLaba.ders6_ders7_JPA.dto.ProductResponseByCategoryDto;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.ProductJpa;
import org.mapstruct.Mapper;


// bu yapi product servis icindeki MapStruct map  yapisi icin kurulmustur.
@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponseByCategoryDto productToProductResponseDtoByCategory(ProductJpa productJpa);
    // product aldigin datayi ProductResponseByCategoryDto ya cevir demek.

}
