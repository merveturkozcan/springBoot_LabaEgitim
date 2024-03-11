package com.merveturk.springBootLaba.ders6_SpringJPA.controller;


import com.merveturk.springBootLaba.ders6_SpringJPA.dto.ProductSaveRequestDtoJpa;
import com.merveturk.springBootLaba.ders6_SpringJPA.service.ProductServiceJPA;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductControllerJPA {

    private final ProductServiceJPA productServiceJPA;

    public ProductControllerJPA(ProductServiceJPA productServiceJPA) {
        this.productServiceJPA = productServiceJPA;
    }


    @RequestMapping("/save")
    public void save (@RequestBody ProductSaveRequestDtoJpa productDtoJpa){
        productServiceJPA.save( productDtoJpa);
    }





}
