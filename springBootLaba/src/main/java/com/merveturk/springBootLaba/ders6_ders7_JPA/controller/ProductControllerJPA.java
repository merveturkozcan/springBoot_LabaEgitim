package com.merveturk.springBootLaba.ders6_ders7_JPA.controller;


import com.merveturk.springBootLaba.ders6_ders7_JPA.dto.ProductSaveRequestDtoJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.service.ProductServiceJPA;
import org.springframework.web.bind.annotation.*;

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





}
