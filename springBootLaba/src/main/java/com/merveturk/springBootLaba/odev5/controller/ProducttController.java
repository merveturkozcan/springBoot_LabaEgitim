package com.merveturk.springBootLaba.odev5.controller;


import com.merveturk.springBootLaba.odev5.service.ProducttService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productt")
public class ProducttController {

    private final ProducttService productService;

    public ProducttController(ProducttService productService) {

        this.productService = productService;
    }

    @PostMapping("/saveProductt")
    public void saveProductt( @RequestParam String name , @RequestParam String category){
        productService.save(name,category );

    }


}
