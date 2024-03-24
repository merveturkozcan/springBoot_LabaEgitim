package com.merveturk.springBootLaba.ders6_ders7_JPA.controller;


import com.merveturk.springBootLaba.ders6_ders7_JPA.dto.ProductResponseByCategoryDto;
import com.merveturk.springBootLaba.ders6_ders7_JPA.dto.ProductSaveRequestDtoJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.service.ProductServiceJPA;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductControllerJPA {

    private final ProductServiceJPA productServiceJPA;

    public ProductControllerJPA(ProductServiceJPA productServiceJPA) {

        this.productServiceJPA = productServiceJPA;
    }

    @PostMapping("/save")
    public void save (@RequestBody ProductSaveRequestDtoJpa productDtoJpa){
        productServiceJPA.save( productDtoJpa);
    }

    @DeleteMapping ()
    public void delete(@RequestParam Long productId){
        productServiceJPA.delete(productId);
    }

    @GetMapping("/productListByCategory/{category}")
    public ResponseEntity<List<ProductResponseByCategoryDto>> productListByCategory (@PathVariable  String category ){

        Optional<List<ProductResponseByCategoryDto>> productResponseByCategoryDtos = productServiceJPA.productListByCategory(category);

        if (productResponseByCategoryDtos.isPresent())
       {
           List<ProductResponseByCategoryDto> productResponseByCategoryDtos1 = productResponseByCategoryDtos.get();
           return ResponseEntity.ok(productResponseByCategoryDtos1);
       }

        return ResponseEntity.notFound().build();
    }


}
