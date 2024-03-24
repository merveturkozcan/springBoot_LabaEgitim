package com.merveturk.springBootLaba.ders6_ders7_JPA.service;


import com.merveturk.springBootLaba.ders6_ders7_JPA.dto.ProductResponseByCategoryDto;
import com.merveturk.springBootLaba.ders6_ders7_JPA.dto.ProductSaveRequestDtoJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.ProductJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.mapper.ProductMapper;
import com.merveturk.springBootLaba.ders6_ders7_JPA.repository.ProductRepositoryJPA;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceJPA {

    private final ProductRepositoryJPA productRepositoryJPA;
    private final ProductMapper productMapper;

    public ProductServiceJPA(ProductRepositoryJPA productRepositoryJPA, ProductMapper productMapper) {
        this.productRepositoryJPA = productRepositoryJPA;
        this.productMapper = productMapper;
    }


    public void save(ProductSaveRequestDtoJpa productSaveRequestDtoJpa) {
        ProductJpa productJPA = new ProductJpa();
        productJPA.setCategory(productSaveRequestDtoJpa.getCategory());
        productJPA.setName(productSaveRequestDtoJpa.getName());
        productRepositoryJPA.save(productJPA);
    }

    public ProductJpa findProductById(Long id) {
        return productRepositoryJPA.findById(id).get();
    }

    public void delete(Long productId) {
        ProductJpa productJpa = productRepositoryJPA.findById(productId).get();
        productRepositoryJPA.delete(productJpa);
    }


    // note : mapper
    public Optional<List<ProductResponseByCategoryDto>> productListByCategory(String category) {

        List<ProductJpa> allByCategory = productRepositoryJPA.findAllByCategory(category);


      /*List<ProductResponseByCategoryDto> list_Dto = allByCategory.stream().map(product -> {
            ProductResponseByCategoryDto productResponseByCategoryDto = new ProductResponseByCategoryDto();
            productResponseByCategoryDto.setName(product.getName());
            productResponseByCategoryDto.setCategory(product.getCategory());
            return productResponseByCategoryDto;
        }).toList();*/


       /*List<ProductResponseByCategoryDto> list_ModelMapper = allByCategory.stream().map(product -> {
            ModelMapper modelMapper = new ModelMapper();
            ProductResponseByCategoryDto productResponseByCategoryDto = modelMapper.map(product, ProductResponseByCategoryDto.class);
            return productResponseByCategoryDto;
        }).toList();*/


       List<ProductResponseByCategoryDto> list_MapStruct = allByCategory.stream().map(productMapper::productToProductResponseDtoByCategory).toList();


        // note : Optional
      return Optional.ofNullable(list_MapStruct);

    }
}